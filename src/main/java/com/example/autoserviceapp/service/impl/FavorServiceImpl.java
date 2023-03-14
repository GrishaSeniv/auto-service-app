package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Favor;
import com.example.autoserviceapp.repository.FavorRepository;
import com.example.autoserviceapp.service.FavorService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@org.springframework.stereotype.Service
public class FavorServiceImpl implements FavorService {
    private final FavorRepository favorRepository;

    public FavorServiceImpl(FavorRepository favorRepository) {
        this.favorRepository = favorRepository;
    }

    @Override
    public Favor save(Favor favor) {
        return favorRepository.save(favor);
    }

    @Override
    public Favor update(Favor favor) {
        return favorRepository.save(favor);
    }

    @Override
    public Favor updatePaidStatus(Long id, Favor.PaidStatus paidStatus) {
        Favor favor = favorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get service by id:" + id));
        favor.setPaidStatus(paidStatus);
        return favorRepository.save(favor);
    }

    @Override
    public List<Favor> findAllByIdIn(List<Long> serviceIds) {
        return favorRepository.findAllByIdIn(serviceIds);
    }
}
