package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.FavorRequestDto;
import com.example.autoserviceapp.dto.response.FavorResponseDto;
import com.example.autoserviceapp.model.Favor;
import com.example.autoserviceapp.service.FavorService;
import com.example.autoserviceapp.service.mapper.FavorMapperDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class FavorController {
    private final FavorService favorService;
    private final FavorMapperDto favorMapperDto;

    public FavorController(FavorService favorService, FavorMapperDto favorMapperDto) {
        this.favorService = favorService;
        this.favorMapperDto = favorMapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save favor to db")
    public FavorResponseDto save(@RequestBody FavorRequestDto favorRequestDto) {
        return favorMapperDto.toDto(
                favorService.save(favorMapperDto.toModel(favorRequestDto)));
    }

    @PutMapping
    @ApiOperation(value = "Update favor in db")
    public FavorResponseDto update(@RequestBody FavorRequestDto favorRequestDto) {
        return favorMapperDto.toDto(
                favorService.save(favorMapperDto.toModel(favorRequestDto)));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update favor status")
    public FavorResponseDto updateStatus(@PathVariable
                                         @ApiParam(value = "Write the favor id you want to update")
                                                 Long id,
                                         @RequestParam
                                         @ApiParam(value = "Write the status(PAID, UNPAID)")
                                                 String paidStatus) {
        return favorMapperDto.toDto(
                favorService.updatePaidStatus(
                        id,
                        Favor.PaidStatus.valueOf(paidStatus.toUpperCase())));
    }
}
