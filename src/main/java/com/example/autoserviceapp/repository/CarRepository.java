package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
