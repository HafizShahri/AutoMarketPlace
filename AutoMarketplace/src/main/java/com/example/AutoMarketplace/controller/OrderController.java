package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Order;
import com.example.AutoMarketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService serv;

    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> GetOrderList (){
        return serv.GetOrderListByCustomer();
    }
    @GetMapping("/ordersByCustomer")
    public ResponseEntity<List<Order>> getOrderListByCustomerId(@RequestParam Long customerId) {
        return serv.getOrderListByCustomerId(customerId);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> AddOrder (@RequestParam Long vehicleId, @RequestParam Long customerId, @RequestParam double price){
        return serv.addOrder( vehicleId, customerId, price);
    }

    @PutMapping("/Purchase")
    public ResponseEntity<String> Purchase(@RequestParam Long orderId) {
        return serv.Purchase(orderId);
    }

    @DeleteMapping("/RemoveOrder")
    public ResponseEntity<String> RemoveOrder(@RequestParam Long orderId){
        return serv.removeOrder(orderId);
    }
}
