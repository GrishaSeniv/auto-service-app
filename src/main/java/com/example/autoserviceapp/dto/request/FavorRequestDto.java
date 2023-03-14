package com.example.autoserviceapp.dto.request;

import com.example.autoserviceapp.model.Favor;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorRequestDto {
    private String serviceName;
    private Long masterId;
    private BigDecimal price;
    private Favor.PaidStatus paidStatus;
}
