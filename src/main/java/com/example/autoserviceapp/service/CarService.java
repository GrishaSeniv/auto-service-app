package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Car;
import java.util.List;

public interface CarService {
    Car save(Car car);

    Car update(Car car);

    List<Car> findAllByIdIn(List<Long> ids);
}
