package com.example.AutoMarketplace.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String type;
    private Integer vehicleYear;
    private Double price;

    // Constructor
    public Vehicle(){}

    public Vehicle(Long id, String brand, String name, String type, Integer vehicleYear, Double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", price=" + price +
                '}';
    }
}