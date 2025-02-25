package com.example.AutoMarketplace.model;

import jakarta.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long vehicleId;
    private Long customerId;
    private double price;
    private String status;
    //private Vehicle vehicle;

    // No-Args Constructor (Required for JPA)
    public Order() {
    }
    // Constructor
    public Order(Long vehicleId, Long customerId, double price, String status) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
    }

    // Getters
    public Long getOrderId() {
        return orderId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
