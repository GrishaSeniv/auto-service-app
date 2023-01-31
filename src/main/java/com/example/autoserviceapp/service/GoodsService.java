package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Goods;

public interface GoodsService {
    Goods save(Goods goods);

    Goods update(Goods goods);
}
