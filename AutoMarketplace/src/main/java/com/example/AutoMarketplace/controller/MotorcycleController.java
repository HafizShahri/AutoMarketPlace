package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Motorcycle;
import com.example.AutoMarketplace.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotorcycleController {
    @Autowired
    private MotorcycleService service;

    @GetMapping("/motorcycles")
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        return new ResponseEntity<>(service.getAllMotorcycles(), HttpStatus.OK);
    }

    @GetMapping("/motorcycle/{id}")
    public ResponseEntity<Motorcycle> getMotorcycle(@PathVariable long id) {
        Motorcycle motorcycle = service.getMotorcycleById(id);

        if (motorcycle != null) {
            return new ResponseEntity<>(motorcycle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/motorcycle")
    public ResponseEntity<?> addMotorcycle(@RequestBody Motorcycle motorcycle) {

        try {
            Motorcycle motorcycle1 = service.addMotorcycle(motorcycle);
            return new ResponseEntity<>(motorcycle1, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/motorcycle/{id}")
    public ResponseEntity<String> updateMotorcycle(@PathVariable long id, @RequestBody Motorcycle motorcycle) {

        Motorcycle motorcycle1 = service.getMotorcycleById(id);

        if (motorcycle1 == null) {
            return new ResponseEntity<>("id not exist", HttpStatus.NOT_FOUND);
        }
        if (motorcycle.getId() != id){
            return new ResponseEntity<>("Id not match", HttpStatus.BAD_REQUEST);
        }
        service.updateMotorcycle(id, motorcycle);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @DeleteMapping("/motorcycle/{id}")
    public ResponseEntity<String> deleteMotorcycle(@PathVariable long id) {

        Motorcycle motorcycle1 = service.getMotorcycleById(id);
        if (motorcycle1 != null) {
            service.deleteMotorcycle(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
