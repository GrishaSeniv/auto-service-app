package com.example.autoserviceapp.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long carId;
    private String description;
    private List<Long> serviceIds;
    private List<Long> goodsIds;
    private BigDecimal price;
    private LocalDateTime expiredTime;
}
