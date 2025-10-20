package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.vehicle_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<vehicle_Entity , Integer> {
}
