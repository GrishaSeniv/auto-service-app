package com.example.autoserviceapp.model;

import java.time.Year;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.autoserviceapp.util.YearAttributeConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @Convert(converter = YearAttributeConverter.class)
    private Year year;
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    private CarOwner carOwner;
}
