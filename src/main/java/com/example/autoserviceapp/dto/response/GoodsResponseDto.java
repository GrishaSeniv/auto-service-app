package com.example.autoserviceapp.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
}
