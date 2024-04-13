package com.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {

    private int productId;
    private String productName;
    private int productPrice;
    private int productQuantity;


}
