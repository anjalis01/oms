package com.intuit.java.oms.model;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhoneNumber;

}
