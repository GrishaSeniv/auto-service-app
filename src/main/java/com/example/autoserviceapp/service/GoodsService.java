package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Goods;
import java.util.List;

public interface GoodsService {
    Goods save(Goods goods);

    Goods update(Goods goods);

    List<Goods> findAllByIdIn(List<Long> goodsIds);
}
