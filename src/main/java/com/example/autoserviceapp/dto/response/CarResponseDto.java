package com.example.autoserviceapp.dto.response;

import com.example.autoserviceapp.model.CarOwner;
import java.time.Year;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Year year;
    private String number;
    private CarOwner carOwner; //dto
}
