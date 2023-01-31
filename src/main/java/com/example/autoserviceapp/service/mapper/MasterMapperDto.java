package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.MasterRequestDto;
import com.example.autoserviceapp.dto.response.MasterResponseDto;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class MasterMapperDto {
    private final OrderService orderService;

    public MasterMapperDto(OrderService orderService) {
        this.orderService = orderService;
    }

    public Master toModel(MasterRequestDto masterRequestDto) {
        Master master = new Master();
        master.setName(masterRequestDto.getName());
        master.setLastName(masterRequestDto.getLastName());
        master.setSurname(masterRequestDto.getSurname());
        master.setOrders(orderService.findAllByIdIn(
                masterRequestDto.getOrdersIds()));
        return master;
    }

    public MasterResponseDto toDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setId(master.getId());
        masterResponseDto.setName(master.getName());
        masterResponseDto.setLastName(master.getLastName());
        masterResponseDto.setSurName(master.getSurname());
        masterResponseDto.setOrders(master.getOrders());
        return masterResponseDto;
    }
}
