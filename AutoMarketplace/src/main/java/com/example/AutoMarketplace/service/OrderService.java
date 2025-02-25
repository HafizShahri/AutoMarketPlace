package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Order;
import com.example.AutoMarketplace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository repo;

    public ResponseEntity<List<Order>> GetOrderListByCustomer (){
        List<Order> orders = new ArrayList<>();
        return ResponseEntity.ok(repo.findAll());
    }
    public ResponseEntity<List<Order>> getOrderListByCustomerId(Long customerId) {
        List<Order> orders = repo.findByCustomerId(customerId);

        if (orders.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(orders);
    }
    public ResponseEntity<Order> addOrder(Long vehicleId, Long customerId, double price){
        Order order = new Order(vehicleId,customerId,price,"Pending purchase");
        //repository to add into table
        return ResponseEntity.ok(repo.save(order));
    }

   public ResponseEntity<String> Purchase(Long orderId){
        Optional<Order> orderOpt = repo.findById(orderId);
       if (orderOpt.isEmpty()) {
           return ResponseEntity.badRequest().body("Order not found");
       }

       // Update the order status to "Purchased"
       Order order = orderOpt.get();
       order.setStatus("Purchased");
       repo.save(order);

       return ResponseEntity.ok("Order has been successfully purchased");
    }

    public ResponseEntity<String> removeOrder(Long orderId){
        if (!repo.existsById(orderId)) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        repo.deleteById(orderId);
        return ResponseEntity.ok("Order removed successfully");
    }
}
