package com.simplecrm2.simplecrm2;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

// Part 2: Building Our simple-crm
@Getter // use Lombok to make code more concise
@Setter
public class Customer {
    private final String id;    
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String jobTitle;
    private int yearOfBirth;

    // constructor to add uuid
    public Customer() {
        this.id = UUID.randomUUID().toString(); // use the UUID class to generate a unique id for us whenever a new Customer object is created.
    }

    // constructor to for preloading for 4 customer objects
    public Customer(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(String id2) {
    }

}
