package com.example.autoserviceapp.dto.response;

import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Goods;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private Car car; //return dto
    private String description;
    private LocalDateTime acceptanceDate;
    private List<Service> services; //dto
    private List<Goods> goods; //dto
    private Order.Status status;
    private BigDecimal price;
    private LocalDateTime expiredTime;
}
