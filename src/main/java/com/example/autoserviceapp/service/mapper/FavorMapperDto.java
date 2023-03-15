package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.FavorRequestDto;
import com.example.autoserviceapp.dto.response.FavorResponseDto;
import com.example.autoserviceapp.model.Favor;
import com.example.autoserviceapp.service.MasterService;
import org.springframework.stereotype.Component;

@Component
public class FavorMapperDto {
    private final MasterService masterService;

    public FavorMapperDto(MasterService masterService) {
        this.masterService = masterService;
    }

    public Favor toModel(FavorRequestDto favorRequestDto) {
        Favor favor = new Favor();
        favor.setServiceName(favorRequestDto.getServiceName());
        favor.setMaster(masterService.getById(favorRequestDto.getMasterId()));
        favor.setPrice(favorRequestDto.getPrice());
        favor.setPaidStatus(favorRequestDto.getPaidStatus());
        return favor;
    }

    public FavorResponseDto toDto(Favor favor) {
        FavorResponseDto favorResponseDto = new FavorResponseDto();
        favorResponseDto.setId(favor.getId());
        favorResponseDto.setServiceName(favor.getServiceName());
        favorResponseDto.setMasterId(favor.getMaster().getId());
        favorResponseDto.setPaidStatus(favor.getPaidStatus());
        favorResponseDto.setPrice(favor.getPrice());
        return favorResponseDto;
    }
}
