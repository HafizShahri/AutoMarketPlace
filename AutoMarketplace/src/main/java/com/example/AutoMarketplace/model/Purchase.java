package com.example.AutoMarketplace.model;

public class Purchase {
    private String purchaseId;
    private String vehicleId;
    private String customerId;
    private double price;
    private String status;

    // Constructor
    public Purchase(String purchaseId, String carId, String customerId, double price, String status) {
        this.purchaseId = purchaseId;
        this.vehicleId = carId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
    }

    // Getters
    public String getPurchaseId() {
        return purchaseId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
