package com.intuit.java.oms.controller;

import com.intuit.java.oms.exception.ProductNotFound;
import com.intuit.java.oms.model.Product;
import com.intuit.java.oms.service.OmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OmsProductController {

    @Autowired
    OmsProductService omsProductService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
            List<Product> productList = new ArrayList<Product>();
            System.out.println("into controller");
            productList =  omsProductService.findAllProduct();
            if (productList.isEmpty()) {
                throw new ProductNotFound();
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
            System.out.println("into controller");
             Product product =  omsProductService.findProductById(id);
            if (product == null) {
                throw  new ProductNotFound();
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
