package com.intuit.java.oms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonSerialize
public class Product {

    private int productId;
    private String productName;
    private Double price;
    private int quantity;
}
