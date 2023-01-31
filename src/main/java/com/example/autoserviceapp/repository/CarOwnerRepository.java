package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
}
