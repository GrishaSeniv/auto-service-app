package com.example.autoserviceapp.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MasterResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String surName;
    private List<OrderResponseDto> orders;
}
