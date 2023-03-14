package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Goods;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllByIdIn(List<Long> goodsIds);
}
