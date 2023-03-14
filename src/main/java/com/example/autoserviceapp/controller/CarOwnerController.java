package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.CarOwnerRequestDto;
import com.example.autoserviceapp.dto.response.CarOwnerResponseDto;
import com.example.autoserviceapp.dto.response.OrderResponseDto;
import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.service.CarOwnerService;
import com.example.autoserviceapp.service.mapper.CarOwnerMapperDto;
import com.example.autoserviceapp.service.mapper.OrderMapperDto;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-owners")
public class CarOwnerController {
    private final CarOwnerService carOwnerService;
    private final CarOwnerMapperDto carOwnerMapperDto;
    private final OrderMapperDto orderMapperDto;

    public CarOwnerController(CarOwnerService carOwnerService,
                              CarOwnerMapperDto carOwnerMapperDto,
                              OrderMapperDto orderMapperDto) {
        this.carOwnerService = carOwnerService;
        this.carOwnerMapperDto = carOwnerMapperDto;
        this.orderMapperDto = orderMapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save car owner to db")
    public CarOwnerResponseDto save(@RequestBody CarOwnerRequestDto carOwnerRequestDto) {
        CarOwner carOwner = carOwnerMapperDto.toModel(carOwnerRequestDto);
        return carOwnerMapperDto.toDto(carOwnerService.save(carOwner));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update car owner in db")
    public CarOwnerResponseDto update(@RequestBody CarOwnerRequestDto carOwnerRequestDto,
                                      @PathVariable
                                      @ApiParam(value = "Write the car owner id you want to update")
                                              Long id) {
        CarOwner carOwner = carOwnerMapperDto.toModel(carOwnerRequestDto);
        carOwner.setId(id);
        return carOwnerMapperDto.toDto(carOwnerService.update(carOwner));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get all orders for this client")
    public List<OrderResponseDto> getOrders(@PathVariable
                                            @ApiParam(value = "Write client id") Long id) {
        return carOwnerService.getOrders(id)
                .stream()
                .map(orderMapperDto::toDto)
                .collect(Collectors.toList());
    }
}
