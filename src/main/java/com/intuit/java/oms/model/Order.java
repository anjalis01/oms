package com.intuit.java.oms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
public class Order {

    private int orderId;
    private int customerId;
    private int productId;
    private int productQuantity;
    private Double price;
}
