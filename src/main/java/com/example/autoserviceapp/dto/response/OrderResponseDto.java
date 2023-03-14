package com.example.autoserviceapp.dto.response;

import com.example.autoserviceapp.model.Goods;
import com.example.autoserviceapp.model.Order;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String description;
    private LocalDateTime acceptanceDate;
    private List<FavorResponseDto> favors;
    private List<Goods> goods;
    private Order.Status status;
    private BigDecimal price;
    private LocalDateTime expiredTime;
}
