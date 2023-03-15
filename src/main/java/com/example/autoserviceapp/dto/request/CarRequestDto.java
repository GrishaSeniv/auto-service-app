package com.example.autoserviceapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDto {
    private String brand;
    private String model;
    private Short year;
    private String number;
    private Long carOwnerId;
}
