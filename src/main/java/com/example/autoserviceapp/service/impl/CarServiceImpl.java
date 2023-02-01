package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public List<Car> findAllByIdIn(List<Long> ids) {
        return repository.findAllByIdIn(ids);
    }
}
