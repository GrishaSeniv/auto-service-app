package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByIdIn(List<Long> ids);

    Optional<Car> findById(Long id);
}
