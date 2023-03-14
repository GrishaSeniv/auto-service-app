package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface MasterService {
    Master save(Master master);

    Master update(Master master);

    List<Order> getOrders(Long id);

    Master getById(Long id);

    String calculateSalary(Long orderId);
}
