package com.example.AutoMarketplace.model;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private Integer doors;

    // Constructor
    public Car()
    {
        super();
    }

    public Car(String brand, String model, Integer year, Double price)
    {
        super(brand, model, year, price);
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
}
