package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.model.Order;
import java.util.List;

public interface CarOwnerService {
    CarOwner getById(Long id);

    CarOwner save(CarOwner carOwner);

    CarOwner update(CarOwner carOwner);

    List<Order> getOrders(Long id);

    CarOwner findByOrders(Order order);
}
