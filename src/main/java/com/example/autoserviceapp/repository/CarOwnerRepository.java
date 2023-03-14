package com.example.autoserviceapp.repository;

import java.util.Optional;
import com.example.autoserviceapp.model.CarOwner;
import com.example.autoserviceapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    Optional<CarOwner> findByOrders(Order order);
}
