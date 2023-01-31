package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperDto {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setCar(order.getCar());
        orderResponseDto.setDescription(order.getDescription());
        orderResponseDto.setAcceptanceDate(order.getAcceptanceDate());
        orderResponseDto.setServices(order.getServices());
        orderResponseDto.setGoods(order.getGoods());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setExpiredTime(order.getExpiredTime());
        return orderResponseDto;
    }
}
