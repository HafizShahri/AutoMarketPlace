package com.example.AutoMarketplace.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private Integer vehicleYear;
    private Double price;

    // Constructor
    public Vehicle(){}

    public Vehicle(Long id, String brand, String name, Integer vehicleYear, Double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.vehicleYear = vehicleYear;
        this.price = price;
    }

    // Setter and getter method
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer year) {
        this.vehicleYear = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + name + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", price=" + price +
                '}';
    }
}