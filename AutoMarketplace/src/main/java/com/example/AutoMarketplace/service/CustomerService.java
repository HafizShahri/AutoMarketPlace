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
        return repo.save(customer);
    }

    public Customer updateCustomer(long id, Customer customer) {
        return repo.save(customer);
    }

    public void deleteCustomer(long id) {
        repo.deleteById(id);
    }
}
