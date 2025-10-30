package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<VehicleEntity, Integer> {
    VehicleEntity findByid (Integer id);
    List<VehicleEntity> findByNameContainingIgnoreCase (String name);
    List<VehicleEntity> findByAvailable(Boolean available);
    List<VehicleEntity> findByPricePerDayLessThan(Double price);
}
