package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Goods;
import com.example.autoserviceapp.repository.GoodsRepository;
import com.example.autoserviceapp.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository repository;

    public GoodsServiceImpl(GoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Goods save(Goods goods) {
        return repository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        return repository.save(goods);
    }
}
