package com.training.service.service_impl;

import com.training.dao.AbstractDAO;
import com.training.dao.OrderDAO;
import com.training.model.Order;
import com.training.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private AbstractDAO dao = new OrderDAO();;

    @Override
    public void addOrder(Order order) {
        dao.add(order);
    }

    @Override
    public List<Order> getListOrders() {
        return dao.getAll();
    }

    @Override
    public Order getOrder(Long userId) {
        return (Order) dao.getById(userId);
    }
}
