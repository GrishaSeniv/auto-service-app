package com.example.autoserviceapp.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsRequestDto {
    private String name;
    private BigDecimal price;
}
