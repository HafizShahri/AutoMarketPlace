package com.example.AutoMarketplace.service;

import com.example.AutoMarketplace.model.Motorcycle;
import com.example.AutoMarketplace.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {
    @Autowired
    private MotorcycleRepository repo;

    public List<Motorcycle> getAllMotorcycles() {
        return repo.findAll();
    }

    public Motorcycle getMotorcycleById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Motorcycle addMotorcycle(Motorcycle motorcycle) {
        return repo.save(motorcycle);
    }

    public Motorcycle updateMotorcycle(long id, Motorcycle motorcycle) {
        return repo.save(motorcycle);
    }

    public void deleteMotorcycle(long id) {
        repo.deleteById(id);
    }
}
