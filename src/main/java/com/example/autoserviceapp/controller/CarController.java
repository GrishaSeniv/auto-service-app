package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.CarRequestDto;
import com.example.autoserviceapp.dto.response.CarResponseDto;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.service.CarService;
import com.example.autoserviceapp.service.mapper.CarMapperDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapperDto carMapperDto;

    public CarController(CarService carService, CarMapperDto carMapperDto) {
        this.carService = carService;
        this.carMapperDto = carMapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save car to db")
    public CarResponseDto save(@RequestBody CarRequestDto carRequestDto) {
        Car car = carMapperDto.toModel(carRequestDto);
        return carMapperDto.toDto(carService.save(car));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update car in db")
    public CarResponseDto update(@RequestBody CarRequestDto carRequestDto,
                                 @PathVariable
                                 @ApiParam(value = "Write the car id you want to update")
                                         Long id) {
        Car car = carMapperDto.toModel(carRequestDto);
        car.setId(id);
        return carMapperDto.toDto(carService.update(car));
    }
}
