package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Purchase;
import com.example.AutoMarketplace.repository.PurchaseRepository;

import java.util.UUID;

public class PurchaseService {
    private final PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Purchase purchaseVehicle(String carId, String customerId, double price) {
        Purchase purchase = new Purchase(UUID.randomUUID().toString(), carId, customerId, price, "Completed");
        repository.save(purchase);
        return purchase;
    }

}
