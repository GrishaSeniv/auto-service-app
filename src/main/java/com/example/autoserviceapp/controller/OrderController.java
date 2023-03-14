package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.OrderRequestDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.OrderService;
import com.example.autoserviceapp.service.mapper.OrderMapperDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapperDto orderMapperDto;

    public OrderController(OrderService orderService, OrderMapperDto orderMapperDto) {
        this.orderService = orderService;
        this.orderMapperDto = orderMapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save order to db")
    public OrderResponseDto save(@RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderMapperDto.toModel(orderRequestDto);
        return orderMapperDto.toDto(orderService.save(order));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update order in db")
    public OrderResponseDto update(@RequestBody OrderRequestDto orderRequestDto,
                                   @PathVariable
                                   @ApiParam(value = "Write the car owner id you want to update")
                                           Long id) {
        Order order = orderMapperDto.toModel(orderRequestDto);
        order.setId(id);
        return orderMapperDto.toDto(orderService.update(order));
    }

    @PostMapping("/{orderId}/goods")
    @ApiOperation(value = "add goods to order")
    public OrderResponseDto addGoods(@PathVariable
                                     @ApiParam(value = "Write the order id you wand to add goods")
                                             Long orderId,
                                     @RequestParam
                                     @ApiParam(value = "Write the goods id ")
                                             Long goodsId) {
        return orderMapperDto.toDto(orderService.addGoods(orderId, goodsId));
    }

    @PostMapping("/{orderId}/favors/{favorId}")
    @ApiOperation(value = "add favor to order")
    public OrderResponseDto addFavor(@PathVariable
                                     @ApiParam(value = "Write the order id you wand to add favor")
                                             Long orderId,
                                     @PathVariable
                                     @ApiParam(value = "Write the favor id")
                                             Long favorId) {
        return orderMapperDto.toDto(orderService.addFavor(orderId, favorId));
    }

    @PutMapping("/status/{id}")
    @ApiOperation(value = "update status")
    public OrderResponseDto updateStatus(
            @PathVariable
            @ApiParam(value = "Write the order id you wand to update the status") Long id,
            @RequestParam
            @ApiParam(value = "Write the status"
                    + "(ACCEPTED, IN_PROCESS, SUCCESSFULLY_COMPLETED, "
                    + "UNSUCCESSFULLY_COMPLETED, PAID)")
                    String status) {
        return orderMapperDto.toDto(orderService.updateStatus(id,
                Order.Status.valueOf(status.toUpperCase())));
    }

    @GetMapping("/{orderId}/price")
    @ApiOperation(value = "get final price for order")
    public BigDecimal getFinalPrice(
            @PathVariable
            @ApiParam(value = "Write the order id you wand to get final price") Long orderId) {
        return orderService.getFinalPrice(orderId);
    }
}
