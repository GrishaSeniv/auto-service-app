package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByIdIn(List<Long> ids);
}
