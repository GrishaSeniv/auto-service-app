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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public MasterResponseDto save(MasterRequestDto masterRequestDto) {
        Master master = mapperDto.toModel(masterRequestDto);
        return mapperDto.toDto(masterService.save(master));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update master in db")
    public MasterResponseDto update(MasterRequestDto masterRequestDto,
                                    @PathVariable
                                    @ApiParam(value = "Write the master id you want to update") Long id) {
        Master master = mapperDto.toModel(masterRequestDto);
        master.setId(id);
        return mapperDto.toDto(masterService.update(master));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        Master master = masterService.getById(id);
        return master.getOrders()
                .stream()
                .map(orderMapperDto::toDto)
                .collect(Collectors.toList());
    }
}
