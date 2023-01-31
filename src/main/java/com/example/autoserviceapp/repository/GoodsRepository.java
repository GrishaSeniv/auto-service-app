package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
