package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.OrderService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> findAllByIdIn(List<Long> ids) {
        return repository.findAllByIdIn(ids);
    }
}
