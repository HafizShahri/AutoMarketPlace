package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/car/")
    public ResponseEntity<?> getCar() {
        return new ResponseEntity<>("Product not found", HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCar(@PathVariable long id) {
        //Car car = service.getCarById(id);
        Car car1 = service.getCarById(id);
        System.out.println(car1);
        if (car1 != null) {
            Car car2 = service.getCarById(id);
            return new ResponseEntity<>(car2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<?> addProduct(@RequestBody Car car) {

        try {
            Car car1 = service.addCar(car);
            return new ResponseEntity<>(car1, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/car/")
    public ResponseEntity<String> updateProduct() {

        return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody Car car) {

        Car car1 = service.getCarById(id);
        System.out.println(car1);
        if (car1 != null) {
            service.updateCar(id, car);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/car/")
    public ResponseEntity<String> deleteProduct() {

        return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {

        Car car1 = service.getCarById(id);
        if (car1 != null) {
            service.deleteCar(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
        }
    }
}
