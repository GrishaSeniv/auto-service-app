package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Favor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorRepository extends JpaRepository<Favor, Long> {
    List<Favor> findAllByIdIn(List<Long> serviceIds);
}
