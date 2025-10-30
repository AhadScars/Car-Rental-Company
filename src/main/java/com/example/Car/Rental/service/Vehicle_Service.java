package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.VehicleEntity;
import com.example.Car.Rental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vehicle_Service {

    @Autowired
    VehicleRepo repo;

    public List<VehicleEntity> getAll(){
        return repo.findAll();
    }
    public VehicleEntity addVehicle(VehicleEntity vehicleEntity){
        return repo.save(vehicleEntity);
    }
    public void deleteAll(){
        repo.deleteAll();
    }
    public VehicleEntity findBYid(Integer id){
        return repo.findByid(id);
    }
    public void deleteByid(Integer id){
        repo.deleteById(id);
    }
    public VehicleEntity editvehicle(Integer id , VehicleEntity entity){
        VehicleEntity edit = repo.findByid(id);

        edit.setBrand(entity.getBrand());
        edit.setAvailable(entity.getAvailable());
        edit.setName(entity.getName());
        edit.setVehicleType(entity.getVehicleType());
        edit.setPricePerDay(entity.getPricePerDay());

        return repo.save(edit);
    }
    public List<VehicleEntity> findByname(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<VehicleEntity> findByAvailable(Boolean available){
        return repo.findByAvailable(available);
    }

    public List<VehicleEntity> findByPriceLessthan(Double price){
        return repo.findByPricePerDayLessThan(price);
    }
}
