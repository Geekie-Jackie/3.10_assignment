package com.simplecrm2.simplecrm2;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Part 2: Building Our simple-crm

@RestController
public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList<>(); // create arraylist to store customer objects

    // Create (POST)
    // method to add 1 Customer object. Expected to return Customer.
    // @PostMapping("/customers")
    // public Customer createCustomer(@RequestBody Customer customer) { // When
    // Spring Boot sees the @RequestBody
    // // annotation, it looks for a Java class with the
    // // name of the type specified by the annotation. In
    // // this case, the type is Customer, so Spring Boot
    // // looks for a class called Customer.java.
    // // @RequestBody annotation also tells Spring Boot
    // // to deserialize the JSON payload from the HTTP
    // // request body into a Java object of the type
    // // specified by the annotation.
    // customers.add(customer); // add customer object to arrayList
    // return customer;
    // }

    // Create 1 with ResponseEntity (POST)
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // Read (GET ALL)
    // @GetMapping("/customers")
    // public ArrayList<Customer> getAllCustomers() {
    // return customers; // return entire arraylist
    // }

    // Read (GET ALL) with ResponseEntity
    @GetMapping("/customers")
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
        // return customers; // return entire arraylist
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // preload 4 customer data
    public CustomerController() {
        customers.add(new Customer("Bruce", "Banner"));
        customers.add(new Customer("Peter", "Parker"));
        customers.add(new Customer("Stephen", "Strange"));
        customers.add(new Customer("Steve", "Rogers"));
    }

    // helper function to get specific ID
    private int getCustomerIndex(String id) {
        for (Customer customer : customers) { // enhanced for loop to loop through the arraylist
            if (customer.getId().equals(id)) {
                return customers.indexOf(customer); // return index of the arraylist if uuid matches
            }
        }

        // Not found
        // return -1;
        // throw Custom Exception here by creating a exception object
        throw new CustomerNotFoundException(id);
    }

    // Read (GET 1)
    // @GetMapping("/customers/{id}")
    // public Customer getCustomer(@PathVariable String id) {
    // int index = getCustomerIndex(id); // call helper function using pathvariable
    // id
    // return customers.get(index); // return the arraylist object using the matched
    // uuid
    // }

    // Read (GET 1) with ResponseEntity
    // add try catch for custom exception
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        try {
            int index = getCustomerIndex(id); // call helper function using pathvariable id
            // return customers.get(index); // return the arraylist object using the matched
            // uuid
            return new ResponseEntity<>(customers.get(index), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Update (PUT)
    // @PutMapping("/customers/{id}")
    // public Customer updateCustomer(@PathVariable String id, @RequestBody Customer
    // customer) { // 2 parameters: 1 the
    // // customer id to update
    // // and also
    // int index = getCustomerIndex(id);
    // customers.set(index, customer); // param 1 index: The index of the element to
    // be replaced. param 2 element: The
    // // new element that is to be stored at index.
    // return customer;
    // }

    // Update (PUT) with ResponseEntity
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) { // 2
                                                                                                              // parameters:
                                                                                                              // 1 the
        // customer id to update
        // and also
        try {
            int index = getCustomerIndex(id);
            customers.set(index, customer); // param 1 index: The index of the element to be replaced. param 2 element:
                                            // The new element that is to be stored at index.
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update (PUT) - create new object if the uuid doesn't exist
    // @PutMapping("/customers/{id}")
    // public Customer updateCustomer2(@PathVariable String id, @RequestBody
    // Customer customer) {
    // int index = getCustomerIndex(id);

    // if (index == -1) {
    // customer.setId(id);
    // customers.add(customer);
    // return customer;
    // }

    // customers.set(index, customer);
    // return customer;
    // }

    // Delete 1
    // @DeleteMapping("/customers/{id}")
    // public Customer deleteCustomer(@PathVariable String id) {
    // int index = getCustomerIndex(id);
    // return customers.remove(index);
    // }

    // Delete 1 with Response Entity
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id) {
        try {
            int index = getCustomerIndex(id);
            // return customers.remove(index);
            customers.remove(index);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
