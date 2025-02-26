package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Order.Order;
import com.example.AutoMarketplace.model.Order.OrderDetails;
import com.example.AutoMarketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService serv;

    @GetMapping("/customer={customerId}/ordersByCustomer")
    public ResponseEntity<List<OrderDetails>> GetOrderList(@PathVariable Long customerId) {
        return serv.getOrderListByCustomerId(customerId);
    }

    @PostMapping("/customer={customerId}/motorcycle/addOrder={vehicleId}")
    public ResponseEntity<Order> AddOrderMotorcycle(@PathVariable Long vehicleId, @PathVariable Long customerId){
        return serv.addOrder( "motorcycle", vehicleId, customerId);
    }

    @PostMapping("/customer={customerId}/car/addOrder={vehicleId}")
    public ResponseEntity<Order> AddOrderCar(@PathVariable Long vehicleId, @PathVariable Long customerId){
        return serv.addOrder( "car", vehicleId, customerId);
    }

    @PutMapping("/customer={customerId}/Purchase/{orderId}")
    public ResponseEntity<String> Purchase(@PathVariable Long orderId, @PathVariable Long customerId) {
        return serv.Purchase(orderId);
    }

    @DeleteMapping("/customer={customerId}/RemoveOrder/{orderId}")
    public ResponseEntity<String> RemoveOrder(@PathVariable Long orderId, @PathVariable Long customerId){
        return serv.removeOrder(orderId);
    }
}
