package com.intuit.java.oms.service;

import com.intuit.java.oms.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OmsProductService {
    public List<Product> findAllProduct();

    public Product findProductById(int productId);

}
