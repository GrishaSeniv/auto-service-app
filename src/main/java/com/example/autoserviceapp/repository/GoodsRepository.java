package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllByIdIn(List<Long> goodsIds);
}
