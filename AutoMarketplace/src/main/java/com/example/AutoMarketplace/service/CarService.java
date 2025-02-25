package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Car;
import com.example.AutoMarketplace.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository repo;

    public List<Car> getAllCars() {
        return repo.findAll();
    }

    public Car getCarById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Car addCar(Car car) {
        return repo.save(car);
    }

    public Car updateCar(long id, Car car) {
        return repo.save(car);
    }

    public void deleteCar(long id) {
        repo.deleteById(id);
    }
}
