package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Favor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorRepository extends JpaRepository<Favor, Long> {
    List<Favor> findAllByIdIn(List<Long> serviceIds);
}
