package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.CarOwnerRequestDto;
import com.example.autoserviceapp.dto.response.CarOwnerResponseDto;
import com.example.autoserviceapp.dto.response.CarResponseDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarOwnerMapperDto {
    private final CarService carService;
    private final OrderRepository orderRepository;
    private final CarMapperDto carMapperDto;
    private final OrderMapperDto orderMapperDto;

    public CarOwnerMapperDto(CarService carService,
                             OrderRepository orderRepository,
                             CarMapperDto carMapperDto,
                             OrderMapperDto orderMapperDto) {
        this.carService = carService;
        this.orderRepository = orderRepository;
        this.carMapperDto = carMapperDto;
        this.orderMapperDto = orderMapperDto;
    }

    public CarOwner toModel(CarOwnerRequestDto carOwnerRequestDto) {
        CarOwner carOwner = new CarOwner();
        carOwner.setCars(carService.findAllByIdIn(carOwnerRequestDto.getCarIds()));
        carOwner.setOrders(orderRepository.findAllByIdIn(carOwnerRequestDto.getOrderIds()));
        return carOwner;
    }

    public CarOwnerResponseDto toDto(CarOwner carOwner) {
        CarOwnerResponseDto carOwnerResponseDto = new CarOwnerResponseDto();
        carOwnerResponseDto.setId(carOwner.getId());
        List<CarResponseDto> carResponseDtos = carOwner.getCars()
                .stream()
                .map(carMapperDto::toDto)
                .collect(Collectors.toList());
        carOwnerResponseDto.setCarResponseDtos(carResponseDtos);
        List<OrderResponseDto> orderResponseDtos = carOwner.getOrders()
                .stream()
                .map(orderMapperDto::toDto)
                .collect(Collectors.toList());
        carOwnerResponseDto.setOrderResponseDtos(orderResponseDtos);
        return carOwnerResponseDto;
    }
}
