package com.example.AutoMarketplace.controller;

import com.example.AutoMarketplace.model.Vehicle;
import com.example.AutoMarketplace.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        return new ResponseEntity<>(service.getAllVehicle(), HttpStatus.OK);
    }

}
