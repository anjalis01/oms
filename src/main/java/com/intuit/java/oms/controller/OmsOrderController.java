package com.intuit.java.oms.controller;

import com.intuit.java.oms.exception.OrderNotFound;
import com.intuit.java.oms.model.Order;
import com.intuit.java.oms.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OmsOrderController {

    @Autowired
    OmsOrderService omsOrderService;


    @PostMapping("/order/submit")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
           Integer orderId = omsOrderService.createOrder(order);
            if (orderId == null) {
                throw new OrderNotFound();
            }
            String message = "Order created with order id "+orderId;
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllProducts() {
        List<Order> orderList = new ArrayList<Order>();
        System.out.println("into controller");
        orderList =  omsOrderService.findAllOrders();
        if (orderList.isEmpty()) {
            throw new OrderNotFound();
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable int orderId) {
        System.out.println("into Order controller");
        Order order =  omsOrderService.findOrderById(orderId);
        if (order == null) {
            throw  new OrderNotFound();
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}
