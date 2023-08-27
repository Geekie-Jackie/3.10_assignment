// Product.java and ProdcutController.java are for Assignment 3.10

package com.simplecrm2.simplecrm2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ProductController {

    private ArrayList<Product> products = new ArrayList<>(); // create arraylist to store product objects

    // Create 1 with ResponseEntity (POST)
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Read (GET ALL) with ResponseEntity
    @GetMapping("/products")
    public ResponseEntity<ArrayList<Product>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Read (GET 1) with ResponseEntity
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
