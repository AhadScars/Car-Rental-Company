package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.vehicle_Entity;
import com.example.Car.Rental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vehicle_Service {

    @Autowired
    VehicleRepo repo;

    public List<vehicle_Entity> getAll(){
        return repo.findAll();
    }
    public vehicle_Entity addVehicle(vehicle_Entity vehicleEntity){
        return repo.save(vehicleEntity);
    }
    public void deleteAll(){
        repo.deleteAll();
    }

}
