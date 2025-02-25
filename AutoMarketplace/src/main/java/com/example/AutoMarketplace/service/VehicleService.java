package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.model.Motorcycle;
import com.example.AutoMarketplace.model.Vehicle;
import com.example.AutoMarketplace.repository.CarRepository;
import com.example.AutoMarketplace.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private CarRepository carRepo;
    @Autowired
    private MotorcycleRepository motorRepo;

    public List<Vehicle> getAllVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();

        List<Car> cars = carRepo.findAll();
        for (Car car : cars) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(car.getId());
            vehicle.setBrand(car.getBrand());
            vehicle.setName(car.getName());
            vehicle.setType(car.getType());
            vehicle.setPrice(car.getPrice());
            vehicle.setVehicleYear(car.getVehicleYear());

            vehicles.add(vehicle);
        }

        List<Motorcycle> motorcycles = motorRepo.findAll();
        for (Motorcycle motorcycle : motorcycles) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(motorcycle.getId());
            vehicle.setBrand(motorcycle.getBrand());
            vehicle.setName(motorcycle.getName());
            vehicle.setType(motorcycle.getType());
            vehicle.setPrice(motorcycle.getPrice());
            vehicle.setVehicleYear(motorcycle.getVehicleYear());

            vehicles.add(vehicle);
        }

        return vehicles;
    }
}
