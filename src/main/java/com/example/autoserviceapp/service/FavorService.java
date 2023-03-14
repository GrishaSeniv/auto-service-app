package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Favor;

import java.util.List;

public interface FavorService {
    Favor save(Favor favor);

    Favor update(Favor favor);

    Favor updatePaidStatus(
            Long id,
            Favor.PaidStatus paidStatus);

    List<Favor> findAllByIdIn(List<Long> serviceIds);
}
