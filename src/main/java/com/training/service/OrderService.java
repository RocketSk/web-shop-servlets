package com.training.service;

import com.training.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    List<Order> getListOrders();

    Order getOrder(Long userId);
}
