package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> findAllByIdIn(List<Long> ids);
}
