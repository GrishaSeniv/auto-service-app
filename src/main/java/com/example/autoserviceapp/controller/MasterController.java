package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.MasterRequestDto;
import com.example.autoserviceapp.dto.response.MasterResponseDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.service.MasterService;
import com.example.autoserviceapp.service.mapper.MasterMapperDto;
import com.example.autoserviceapp.service.mapper.OrderMapperDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterMapperDto mapperDto;
    private final OrderMapperDto orderMapperDto;

    public MasterController(MasterService masterService,
                            MasterMapperDto mapperDto,
                            OrderMapperDto orderMapperDto) {
        this.masterService = masterService;
        this.mapperDto = mapperDto;
        this.orderMapperDto = orderMapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save masters to db")
    public MasterResponseDto save(@RequestBody MasterRequestDto masterRequestDto) {
        Master master = mapperDto.toModel(masterRequestDto);
        return mapperDto.toDto(masterService.save(master));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update master in db")
    public MasterResponseDto update(@RequestBody MasterRequestDto masterRequestDto,
                                    @PathVariable
                                    @ApiParam(value = "Write the master id you want to update")
                                            Long id) {
        Master master = mapperDto.toModel(masterRequestDto);
        master.setId(id);
        return mapperDto.toDto(masterService.update(master));
    }

    @GetMapping("/orders/{id}")
    @ApiOperation(value = "Get all successful or paid orders")
    public List<OrderResponseDto> getOrders(
            @PathVariable
            @ApiParam(value = "Write the master id you want to get orders") Long id) {
        return masterService.getOrders(id)
                .stream()
                .map(orderMapperDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/orders/{orderId}/salary")
    public String calculateSalary(
            @PathVariable
            @ApiParam(value = "Write order id you want to calculate the salary for") Long orderId) {
        return masterService.calculateSalary(orderId);
    }
}
