package com.intuit.java.oms.repository;

import com.intuit.java.oms.model.Order;
import com.intuit.java.oms.service.OmsOrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class OmsOrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int insert(Order order) {
       String INSERT_MESSAGE_SQL = "insert into orders (customer_id, product_id, product_quantity, price) values(?,  ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        System.out.println("in order repo");
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getProductId());
            ps.setInt(3, order.getProductQuantity());
            ps.setDouble(4, order.getPrice());
            return ps;
        }, keyHolder);

        System.out.println("orderId value");
        return (int)  keyHolder.getKey();

    }



    public List<Order> findAll() {
        List<Order> orders = jdbcTemplate.query("select * from orders", new OmsOrderRowMapper());
        System.out.println(orders);
        return orders;
    }

    public Order findById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OmsOrderRowMapper());

    }
}