package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Customer;
import com.example.AutoMarketplace.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repo;

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(long id) {
        return repo.findById(id).orElse(null);
    }


    public Customer addCustomer(Customer customer) {
        // Check for email format
        if (customer.getEmail() == null || !customer.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format. Email must contain '@'");
        }

        // Check if email already exists
        if (repo.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        // Save customer if no issues
        return repo.save(customer);
    }
    public Customer updateCustomer(long id, Customer customer) {

        if (customer.getEmail() == null || !customer.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format. Email must contain '@'");
        }

        Customer existingCustomer = repo.findById(id).orElse(null);
        if (existingCustomer == null) {
            throw new IllegalArgumentException("Customer not found with ID: " + id);
        }

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());

        return repo.save(existingCustomer);
    }

    public void deleteCustomer(long id) {
        repo.deleteById(id);
    }
}
