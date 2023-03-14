package com.example.autoserviceapp.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarOwnerResponseDto {
    private Long id;
    private List<CarResponseDto> cars;
    private List<OrderResponseDto> orders;
}
