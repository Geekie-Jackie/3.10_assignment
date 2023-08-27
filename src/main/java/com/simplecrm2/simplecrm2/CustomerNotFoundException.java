package com.simplecrm2.simplecrm2;


// Custom Exception
public class CustomerNotFoundException extends RuntimeException {
  CustomerNotFoundException(String id) {
    super("Could not find customer with id: " + id);
  }
}