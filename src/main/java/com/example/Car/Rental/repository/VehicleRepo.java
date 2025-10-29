package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.vehicle_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.PublicKey;
import java.util.List;

public interface VehicleRepo extends JpaRepository<vehicle_Entity , Integer> {
    vehicle_Entity findByid (Integer id);
    List<vehicle_Entity> findByNameContainingIgnoreCase (String name);
    List<vehicle_Entity> findByAvailable(Boolean available);
    List<vehicle_Entity> findByPricePerDayLessThan(Double price);
}
