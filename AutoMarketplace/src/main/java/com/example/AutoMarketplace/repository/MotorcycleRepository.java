package com.example.AutoMarketplace.repository;

import com.example.AutoMarketplace.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
  }