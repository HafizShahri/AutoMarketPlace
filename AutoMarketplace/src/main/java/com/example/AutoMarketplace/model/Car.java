package com.example.AutoMarketplace.model;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private Integer doors;

    // Constructor
    public Car() {}

    public Car(Long id, String brand, String name, String type, Integer vehicleYear, Double price, Integer doors) {
        super(id, brand, name, type, vehicleYear, price);
        this.doors = doors;
    }

    // Getter and setter method
    public Integer getDoors ()
    {
        return doors;
    }
    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                "} " + super.toString();
    }
}