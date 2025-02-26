package com.example.AutoMarketplace.model.Order;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.model.Motorcycle;
import com.example.AutoMarketplace.model.Vehicle;

public class OrderDetails extends Order {

    public Vehicle vehicle;

    public OrderDetails(Order order, Car car){
        super(order.getOrderId(), order.getVehicleType(), order.getVehicleId(), order.getCustomerId(), order.getStatus());
        this.vehicle = car;
    }
    public OrderDetails(Order order, Motorcycle motor){
        super(order.getOrderId(), order.getVehicleType(), order.getVehicleId(), order.getCustomerId(), order.getStatus());
        this.vehicle = motor;
    }
}
