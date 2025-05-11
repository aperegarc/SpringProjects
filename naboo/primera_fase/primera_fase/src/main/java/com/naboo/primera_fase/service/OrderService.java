package com.naboo.primera_fase.service;

import java.util.List;

import com.naboo.primera_fase.entity.Order;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order saveOrder(Order order);
    public Order updatOrder(Integer id, Order newOrder);
    public void deleteOrder(Integer id);

}
