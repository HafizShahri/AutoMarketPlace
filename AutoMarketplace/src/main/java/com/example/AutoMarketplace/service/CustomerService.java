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

        if (customer.getEmail() == null || !customer.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format. Email must contain '@'");
        }
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
