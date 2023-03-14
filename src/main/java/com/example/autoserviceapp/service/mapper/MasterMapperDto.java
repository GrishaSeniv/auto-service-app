package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.MasterRequestDto;
import com.example.autoserviceapp.dto.response.MasterResponseDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterMapperDto {
    private final OrderService orderService;
    private final OrderMapperDto orderMapperDto;

    public MasterMapperDto(OrderService orderService, OrderMapperDto orderMapperDto) {
        this.orderService = orderService;
        this.orderMapperDto = orderMapperDto;
    }

    public Master toModel(MasterRequestDto masterRequestDto) {
        Master master = new Master();
        master.setName(masterRequestDto.getName());
        master.setLastName(masterRequestDto.getLastName());
        master.setSurname(masterRequestDto.getSurname());
        if (masterRequestDto.getOrdersIds() != null) {
            master.setOrders(orderService.findAllByIdIn(
                    masterRequestDto.getOrdersIds()));
        } else {
            master.setOrders(null);
        }
        return master;
    }

    public MasterResponseDto toDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setId(master.getId());
        masterResponseDto.setName(master.getName());
        masterResponseDto.setLastName(master.getLastName());
        masterResponseDto.setSurName(master.getSurname());
        List<OrderResponseDto> orderResponseDtos = master.getOrders()
                .stream()
                .map(orderMapperDto::toDto)
                .collect(Collectors.toList());
        masterResponseDto.setOrders(orderResponseDtos);
        return masterResponseDto;
    }
}
