package com.example.autoserviceapp.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarOwnerResponseDto {
    private Long id;
    private List<CarResponseDto> cars;
    private List<OrderResponseDto> orders;
}
