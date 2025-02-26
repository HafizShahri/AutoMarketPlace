package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.model.Customer;
import com.example.AutoMarketplace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable long id) {
        Customer customer = service.getCustomerById(id);

        if (customer != null) {
            Customer customer1 = service.getCustomerById(id);
            return new ResponseEntity<>(customer1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {

        try {
            Customer customer1 = service.addCustomer(customer);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {


        Customer customer1  = service.getCustomerById(id);

        if (customer1 != null) {
            service.updateCustomer(id,customer);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User ID not exist", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id) {

        Customer customer1 = service.getCustomerById(id);
        if (customer1 != null) {
            service.deleteCustomer(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User ID not exist", HttpStatus.OK);
        }
    }

}
