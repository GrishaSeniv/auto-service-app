package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    List<Order> findAllByIdIn(List<Long> ids);
    
    Order save(Order order);

    Order addGoods(Long orderId, Long goodsId);

    Order addFavor(Long orderId, Long favorId);

    Order update(Order order);

    Order updateStatus(Long id, Order.Status status);

    BigDecimal getFinalPrice(Long orderId);
}
