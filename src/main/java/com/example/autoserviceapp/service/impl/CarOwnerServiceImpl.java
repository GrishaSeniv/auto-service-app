package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.CarOwnerRepository;
import com.example.autoserviceapp.service.CarOwnerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {
    private final CarOwnerRepository carOwnerRepository;

    public CarOwnerServiceImpl(CarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    @Override
    public CarOwner getById(Long id) {
        return carOwnerRepository.getById(id);
    }

    @Override
    public CarOwner save(CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Override
    public CarOwner update(CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Override
    public List<Order> getOrders(Long id) {
        return carOwnerRepository.getById(id)
                .getOrders();
    }

    @Override
    public CarOwner findByOrders(Order order) {
        return carOwnerRepository.findByOrders(order).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get order by id: " + order));
    }
}
