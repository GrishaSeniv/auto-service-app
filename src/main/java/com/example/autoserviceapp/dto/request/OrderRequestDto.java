package com.example.autoserviceapp.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class OrderRequestDto {
    private Long carId;
    private String description;
    private List<Long> serviceIds;
    private List<Long> goodsIds;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime expiredTime;
}
