package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.model.Customer;
import com.example.AutoMarketplace.model.Motorcycle;
import com.example.AutoMarketplace.model.Order.Order;
import com.example.AutoMarketplace.model.Order.OrderDetails;
import com.example.AutoMarketplace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository repo;
    @Autowired
    private CarService sevCar;
    @Autowired
    private MotorcycleService sevMotor;
    @Autowired
    private CustomerService sevCus;

    public ResponseEntity<List<OrderDetails>> getOrderListByCustomerId(Long customerId) {
        List<Order> orders = repo.findByCustomerId(customerId);
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for (Order order : orders){
            if (order.getVehicleType().equals("car")){
                Car car = sevCar.getCarById(order.getVehicleId());
                OrderDetails orderDetails = new OrderDetails(order, car);
                orderDetailsList.add(orderDetails);
            } else if (order.getVehicleType().equals("motorcycle")) {
                Motorcycle motor = sevMotor.getMotorcycleById(order.getVehicleId());
                OrderDetails orderDetails = new OrderDetails(order, motor);
                orderDetailsList.add(orderDetails);
            }
        }

        if (orderDetailsList.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(orderDetailsList);
    }
    public ResponseEntity<Order> addOrder(String vehicleType, Long vehicleId, Long customerId){
        if (vehicleType.equals("car")){
            Car car = sevCar.getCarById(vehicleId);
            if (car == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (vehicleType.equals("motorcycle")) {
            Motorcycle motor = sevMotor.getMotorcycleById(vehicleId);
            if (motor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = sevCus.getCustomerById(customerId);
        if (customer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Order order = new Order(vehicleType,vehicleId,customerId,"Pending purchase");
        //repository to add into table
        return ResponseEntity.ok(repo.save(order));
    }

   public ResponseEntity<String> Purchase(Long orderId){
        Order orderById = repo.findById(orderId).orElse(null);
       if (orderById == null) {
           return new  ResponseEntity<>("Order not found !",HttpStatus.NOT_FOUND);
       }
       orderById.setStatus("Purchased");
       repo.save(orderById);

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
