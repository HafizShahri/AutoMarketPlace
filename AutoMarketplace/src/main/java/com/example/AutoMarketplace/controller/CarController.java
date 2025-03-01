package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        Car car = service.getCarById(id);

        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @PutMapping("/car/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody Car car) {

        Car car1 = service.getCarById(id);

        if (car1 == null) {
            return new ResponseEntity<>("Id not exist" ,HttpStatus.NOT_FOUND);
        }
        if (car.getId() != id){
            return new ResponseEntity<>("Id not match", HttpStatus.BAD_REQUEST);
        }
        service.updateCar(id, car);
        return new ResponseEntity<>("Updated",HttpStatus.OK);

    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {

        Car car1 = service.getCarById(id);
        if (car1 != null) {
            service.deleteCar(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
