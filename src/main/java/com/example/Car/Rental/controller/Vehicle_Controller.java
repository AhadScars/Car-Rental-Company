package com.example.Car.Rental.controller;

import com.example.Car.Rental.entity.vehicle_Entity;
import com.example.Car.Rental.service.Vehicle_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class Vehicle_Controller {

    @Autowired
    Vehicle_Service service;

    @GetMapping("/show")
    public List<vehicle_Entity> showAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public vehicle_Entity addVehicle(@RequestBody vehicle_Entity vehicleEntity){
        return service.addVehicle(vehicleEntity);
    }
    @DeleteMapping("/delete")
    public void deleteAll(){
        service.deleteAll();
    }

}
