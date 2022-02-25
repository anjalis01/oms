package com.intuit.java.oms.repository;

import com.intuit.java.oms.model.Product;
import com.intuit.java.oms.service.OmsProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OmsProductRepository  {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        List<Product> productList = jdbcTemplate.query("select * from products", new OmsProductRowMapper());
      System.out.println(productList);
      return productList;
    }

    public Product findById(int productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new OmsProductRowMapper());

    }
}
