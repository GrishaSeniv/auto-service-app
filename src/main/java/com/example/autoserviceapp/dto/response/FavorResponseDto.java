package com.example.autoserviceapp.dto.response;

import com.example.autoserviceapp.model.Favor;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorResponseDto {
    private Long id;
    private String serviceName;
    private Long masterId;
    private BigDecimal price;
    private Favor.PaidStatus paidStatus;
}
