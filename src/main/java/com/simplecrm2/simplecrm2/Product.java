// Product.java and ProdcutController.java are for Assignment 3.10

package com.simplecrm2.simplecrm2;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    // attributes
    private final String id;
    private String pdtName;
    private int pdtPrice;
    private String pdtDescription;

    public Product(String id, String pdtName, int pdtPrice, String pdtDescription) {
        this.id = UUID.randomUUID().toString();
        this.pdtName = pdtName;
        this.pdtPrice = pdtPrice;
        this.pdtDescription = pdtDescription;
    }

}
