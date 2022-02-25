package com.intuit.java.oms.service;

import com.intuit.java.oms.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OmsOrderRowMapper implements RowMapper<Order> {


    @Override
    public Order mapRow(ResultSet rs, int rowNum)throws SQLException {
        Order order=new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setCustomerId(rs.getInt("customer_id"));
        order.setPrice(rs.getDouble("price"));
        order.setProductId(rs.getInt("product_id"));
        order.setProductQuantity(rs.getInt("product_quantity"));
        return order;
    }

}