package com.example.AutoMarketplace.repository;

import com.example.AutoMarketplace.model.Purchase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepository {
    private List<Purchase> purchases = new ArrayList<>();

    public void save(Purchase purchase) {
        purchases.add(purchase);
    }

    public List<Purchase> findByCustomerId(String customerId) {
        return purchases.stream()
                .filter(p -> p.getId().equals(customerId))
                .collect(Collectors.toList());
    }
}
