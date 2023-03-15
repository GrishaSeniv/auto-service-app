package com.example.autoserviceapp.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarOwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
