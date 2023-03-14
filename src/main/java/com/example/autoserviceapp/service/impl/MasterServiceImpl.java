package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Favor;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    public static final BigDecimal SALARY_COEFFICIENT = BigDecimal.valueOf(0.4);
    private final MasterRepository masterRepository;
    private final OrderRepository orderRepository;

    public MasterServiceImpl(MasterRepository masterRepository,
                             OrderRepository orderRepository) {
        this.masterRepository = masterRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public List<Order> getOrders(Long id) {
        return masterRepository.getById(id)
                .getOrders()
                .stream()
                .filter(order -> order.getStatus().name()
                        .equals(Order.Status.SUCCESSFULLY_COMPLETED.name())
                        || order.getStatus().name().equals(Order.Status.PAID.name()))
                .collect(Collectors.toList());
    }

    @Override
    public Master getById(Long id) {
        return masterRepository.getById(id);
    }

    @Override
    public String calculateSalary(Long orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        Order order = orderRepository.getById(orderId);
        if (order.getStatus().equals(Order.Status.PAID)) {
            return "Salary for masters with order id: " + orderId + " have already been calculated";
        }
        List<Favor> favors = order.getFavors()
                .stream()
                .filter(favor -> favor.getPaidStatus().equals(Favor.PaidStatus.UNPAID))
                .collect(Collectors.toList());
        stringBuilder.append("Salary for masters with order id: ").append(orderId)
                .append(System.lineSeparator());
        for (Favor favor : favors) {
            BigDecimal salary = favor.getPrice().multiply(SALARY_COEFFICIENT);
            stringBuilder.append("Master id:").append(favor.getMaster().getId())
                    .append(", salary: ").append(salary);
            favor.setPaidStatus(Favor.PaidStatus.PAID);
        }
        order.setStatus(Order.Status.PAID);
        orderRepository.save(order);
        return stringBuilder.toString();
    }
}
