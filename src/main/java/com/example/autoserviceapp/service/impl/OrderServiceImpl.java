package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Favor;
import com.example.autoserviceapp.model.Goods;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.FavorRepository;
import com.example.autoserviceapp.repository.GoodsRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.CarOwnerService;
import com.example.autoserviceapp.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    public static final BigDecimal FAVOR_DISCOUNT = BigDecimal.valueOf(0.02);
    public static final BigDecimal GOODS_DISCOUNT = BigDecimal.valueOf(0.01);
    private final OrderRepository orderRepository;
    private final GoodsRepository goodsRepository;
    private final FavorRepository favorRepository;
    private final CarOwnerService carOwnerService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            GoodsRepository goodsRepository,
                            FavorRepository favorRepository,
                            CarOwnerService carOwnerService) {
        this.orderRepository = orderRepository;
        this.goodsRepository = goodsRepository;
        this.favorRepository = favorRepository;
        this.carOwnerService = carOwnerService;
    }

    @Override
    public List<Order> findAllByIdIn(List<Long> ids) {
        return orderRepository.findAllByIdIn(ids);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addGoods(Long orderId, Long goodsId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get order by id: " + orderId));
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get goods by id: " + goodsId));
        if (!order.getGoods().contains(goods)) {
            order.getGoods().add(goods);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order addFavor(Long orderId, Long favorId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get order by id: " + orderId));
        Favor favor = favorRepository.findById(favorId).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get favor by id: " + favorId));
        if (!order.getFavors().contains(favor)) {
            order.getFavors().add(favor);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(Long id, Order.Status status) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get order by id: " + id));
        if (status.equals(Order.Status.SUCCESSFULLY_COMPLETED)
                || status.equals(Order.Status.UNSUCCESSFULLY_COMPLETED)) {
            order.setExpiredTime(LocalDateTime.now());
        }
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public BigDecimal getFinalPrice(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Couldn't get order by id: " + orderId));
        int numberOfOrders = carOwnerService.findByOrders(order)
                .getOrders().size();
        List<Favor> favors = order.getFavors();
        List<Goods> goods = order.getGoods();
        BigDecimal sumOfFavors = favors.stream()
                .map(Favor::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal sumOfGoods = goods.stream()
                .map(Goods::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal finalPrice = getGoodsDiscount(sumOfGoods, numberOfOrders)
                .add(getFavorDiscount(sumOfFavors, numberOfOrders));
        order.setPrice(finalPrice);
        orderRepository.save(order);
        return finalPrice;
    }

    private BigDecimal getGoodsDiscount(BigDecimal sumOfFavors, int numberOfOrders) {
        BigDecimal discount = GOODS_DISCOUNT.multiply(BigDecimal.valueOf(numberOfOrders));
        BigDecimal goodsWithDiscount = sumOfFavors.multiply(discount);
        return sumOfFavors.subtract(goodsWithDiscount);
    }

    private BigDecimal getFavorDiscount(BigDecimal sumOfGoods, int numberOfOrders) {
        BigDecimal discount = FAVOR_DISCOUNT.multiply(BigDecimal.valueOf(numberOfOrders));
        BigDecimal favorsWithDiscount = sumOfGoods.multiply(discount);
        return sumOfGoods.subtract(favorsWithDiscount);
    }
}
