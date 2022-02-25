package com.intuit.java.oms.service.impl;

import com.intuit.java.oms.model.Order;
import com.intuit.java.oms.repository.OmsOrderRepository;
import com.intuit.java.oms.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    OmsOrderRepository omsOrderRepository;

    @Override
    public int createOrder(Order order) {

        return omsOrderRepository.insert(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return omsOrderRepository.findAll();
    }

    @Override
    public Order findOrderById(int orderId) {
        return omsOrderRepository.findById(orderId);
    }
}
