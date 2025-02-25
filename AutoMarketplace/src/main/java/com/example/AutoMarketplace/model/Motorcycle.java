package com.example.AutoMarketplace.model;

import jakarta.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle{

    public Motorcycle() {}

    public Motorcycle(Long id, String brand, String name, String type, Integer vehicleYear, Double price) {
        super(id, brand, name, type, vehicleYear, price);
    }

    @Override
    public String toString() {
        return "Motorcycle{} " + super.toString();
    }
}
