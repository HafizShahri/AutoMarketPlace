package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Purchase;
import com.example.AutoMarketplace.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {
    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @PostMapping("/buy")
    public ResponseEntity<Purchase> buyCar(@RequestParam String carId, @RequestParam String customerId, @RequestParam double price) {
        Purchase purchase = service.purchaseVehicle(carId, customerId, price);
        return ResponseEntity.ok(purchase);
    }
}
