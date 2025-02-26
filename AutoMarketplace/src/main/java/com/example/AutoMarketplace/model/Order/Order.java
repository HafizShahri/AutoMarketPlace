package com.example.AutoMarketplace.model.Order;

import jakarta.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long orderId;
    protected String vehicleType;
    protected Long vehicleId;
    protected Long customerId;
    protected String status;

    // No-Args Constructor (Required for JPA)
    public Order() {
    }
    // Constructor
    public Order(String vehicleType, Long vehicleId, Long customerId, String status) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.status = status;
    }
    public Order(Long orderId, String vehicleType, Long vehicleId, Long customerId, String status) {
        this.orderId = orderId;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.status = status;
    }

    // Getters
    public Long getOrderId() {
        return orderId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
