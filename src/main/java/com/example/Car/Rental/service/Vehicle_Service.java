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
    public vehicle_Entity findBYid(Integer id){
        return repo.findByid(id);
    }
    public void deleteByid(Integer id){
        repo.deleteById(id);
    }
    public vehicle_Entity editvehicle(Integer id , vehicle_Entity entity){
        vehicle_Entity edit = repo.findByid(id);

        edit.setBrand(entity.getBrand());
        edit.setAvailable(entity.getAvailable());
        edit.setName(entity.getName());
        edit.setVehicleType(entity.getVehicleType());
        edit.setPricePerDay(entity.getPricePerDay());

        return repo.save(edit);
    }
    public List<vehicle_Entity> findByname(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }
}
