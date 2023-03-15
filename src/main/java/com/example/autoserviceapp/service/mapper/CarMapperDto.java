package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.CarRequestDto;
import com.example.autoserviceapp.dto.response.CarResponseDto;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.service.CarOwnerService;
import java.time.Year;
import org.springframework.stereotype.Component;

@Component
public class CarMapperDto {
    private final CarOwnerService carOwnerService;

    public CarMapperDto(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    public Car toModel(CarRequestDto requestDto) {
        Car car = new Car();
        car.setBrand(requestDto.getBrand());
        car.setModel(requestDto.getModel());
        car.setYear(Year.of(requestDto.getYear()));
        car.setNumber(requestDto.getNumber());
        car.setCarOwner(carOwnerService.getById(
                requestDto.getCarOwnerId()));
        return car;
    }

    public CarResponseDto toDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(car.getId());
        carResponseDto.setBrand(car.getBrand());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setYear(car.getYear());
        carResponseDto.setNumber(car.getNumber());
        carResponseDto.setCarOwnerId(car.getCarOwner().getId());
        return carResponseDto;
    }
}
