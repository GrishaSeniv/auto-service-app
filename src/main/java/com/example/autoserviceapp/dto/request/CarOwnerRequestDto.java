package com.example.autoserviceapp.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarOwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
