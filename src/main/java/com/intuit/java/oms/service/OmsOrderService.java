package com.intuit.java.oms.service;

import com.intuit.java.oms.model.Order;

import java.util.List;

public interface OmsOrderService {

    public int createOrder(Order order);

    List<Order> findAllOrders();

    Order findOrderById(int orderId);
}

