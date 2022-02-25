package com.intuit.java.oms.service;

import com.intuit.java.oms.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OmsProductRowMapper implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setPrice(rs.getDouble("product_price"));
        product.setQuantity(rs.getInt("quantity"));
        return product;
    }


}
