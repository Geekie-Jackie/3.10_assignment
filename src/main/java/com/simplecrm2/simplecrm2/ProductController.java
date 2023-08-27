// Product.java and ProdcutController.java are for Assignment 3.10

package com.simplecrm2.simplecrm2;

// spring
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// arraylist
import java.util.ArrayList;

// logger
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ProductController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);

    private ArrayList<Product> products = new ArrayList<>(); // create arraylist to store product objects

    // Create 1 with ResponseEntity (POST)
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        logger.info("🟢 Added 1 new product. Product ID: " + product.getId());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Read (GET ALL) with ResponseEntity
    @GetMapping("/products")
    public ResponseEntity<ArrayList<Product>> getAllProducts() {
        logger.info("🟢 Viewed all product(s).");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Read (GET 1) with ResponseEntity
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                logger.info("🟢 Viewed 1 product. Product ID: " + productId);
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        logger.error("🔴 Incorrect product ID or product ID doesn't exist.");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
