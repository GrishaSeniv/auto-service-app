package com.example.autoserviceapp.service.impl;

import java.util.List;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.service.MasterService;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository repository;

    public MasterServiceImpl(MasterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Master save(Master master) {
        return repository.save(master);
    }

    @Override
    public Master update(Master master) {
        return repository.save(master);
    }

    @Override
    public List<Order> getOrders(Long id) {
        return repository.getById(id).getOrders();
    }

    @Override
    public Master getById(Long id) {
        return repository.getById(id);
    }
}
