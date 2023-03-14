package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.OrderRequestDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.dto.response.FavorResponseDto;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.service.CarService;
import com.example.autoserviceapp.service.FavorService;
import com.example.autoserviceapp.service.GoodsService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperDto {
    private final CarService carService;
    private final GoodsService goodsService;
    private final FavorService favorService;
    private final FavorMapperDto favorMapperDto;

    public OrderMapperDto(CarService carService,
                          GoodsService goodsService,
                          FavorService favorService,
                          FavorMapperDto favorMapperDto) {
        this.carService = carService;
        this.goodsService = goodsService;
        this.favorService = favorService;
        this.favorMapperDto = favorMapperDto;
    }

    public Order toModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCar(carService.findById(orderRequestDto.getCarId()));
        order.setDescription(orderRequestDto.getDescription());
        order.setAcceptanceDate(LocalDateTime.now());
        order.setFavors(favorService.findAllByIdIn(orderRequestDto.getServiceIds()));
        order.setGoods(goodsService.findAllByIdIn(orderRequestDto.getGoodsIds()));
        order.setStatus(Order.Status.ACCEPTED);
        order.setPrice(null);
        order.setExpiredTime(orderRequestDto.getExpiredTime());
        return order;
    }

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setCarId(order.getCar().getId());
        orderResponseDto.setDescription(order.getDescription());
        orderResponseDto.setAcceptanceDate(order.getAcceptanceDate());
        List<FavorResponseDto> favorResponseDtos = order.getFavors().stream()
                .map(favorMapperDto::toDto)
                .collect(Collectors.toList());
        orderResponseDto.setFavors(favorResponseDtos);
        orderResponseDto.setGoods(order.getGoods());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setExpiredTime(order.getExpiredTime());
        return orderResponseDto;
    }
}
