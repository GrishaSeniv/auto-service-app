package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Car;

public interface CarService {
    Car save(Car car);

    Car update(Car car);
}
