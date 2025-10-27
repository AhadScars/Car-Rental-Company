package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.vehicle_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.PublicKey;
import java.util.List;

public interface VehicleRepo extends JpaRepository<vehicle_Entity , Integer> {
    public vehicle_Entity findByid (Integer id);
    public List<vehicle_Entity> findByNameContainingIgnoreCase (String name);
}
