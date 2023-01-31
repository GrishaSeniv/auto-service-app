package com.example.autoserviceapp.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterRequestDto {
    private String name;
    private String lastName;
    private String surname;
    private List<Long> ordersIds;
}
