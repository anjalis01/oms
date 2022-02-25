package com.intuit.java.oms.service.impl;

import com.intuit.java.oms.model.Product;
import com.intuit.java.oms.repository.OmsProductRepository;
import com.intuit.java.oms.service.OmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsProductServiceImpl implements OmsProductService {

    @Autowired
    OmsProductRepository omsProductRepository;


    @Override
    public List<Product> findAllProduct() {
        System.out.println("into Service");
        List<Product> products = omsProductRepository.findAll();
        System.out.println("inservice"+ products);
        return products;
    }

    @Override
    public Product findProductById(int productId) {
        return omsProductRepository.findById(productId);
    }
}
