package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.repository.CarOwnerRepository;
import com.example.autoserviceapp.service.CarOwnerService;
import org.springframework.stereotype.Service;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {
    private final CarOwnerRepository repository;

    public CarOwnerServiceImpl(CarOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarOwner getById(Long id) {
        return repository.getById(id);
    }
}
