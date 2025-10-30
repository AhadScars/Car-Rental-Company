package com.example.Car.Rental.controller;

import com.example.Car.Rental.entity.VehicleEntity;
import com.example.Car.Rental.service.Vehicle_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class Vehicle_Controller {

    @Autowired
    Vehicle_Service service;

    @GetMapping("/show")
       public ResponseEntity<?> showAll(){
        List<VehicleEntity> showAll = service.getAll();
        if (showAll.isEmpty()){
            new ResponseEntity<>("Vehicle IS Empty", HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(showAll, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> AddVehicle(@RequestBody VehicleEntity vehicleEntity){
        VehicleEntity Vehicle = service.addVehicle(vehicleEntity);
        return new ResponseEntity<>("Vehicle Added Succesfull", HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletebyid(@PathVariable Integer id){
        service.deleteByid(id);
    }

    @GetMapping("/show/{id}")
    public VehicleEntity findById(@PathVariable Integer id){
        return service.findBYid(id);
    }

    @PutMapping("/edit/{id}")
    public VehicleEntity editVehicle(@PathVariable Integer id, @RequestBody VehicleEntity entity){
        return service.editvehicle(id,entity);
    }

    @GetMapping("/find/{name}")
    public List<VehicleEntity> findByName(@PathVariable String name){
        return service.findByname(name);
    }

    @GetMapping("/available")
    public List<VehicleEntity> findByAvailable(@RequestParam Boolean available){
        return service.findByAvailable(available);
    }

    @GetMapping("/")
    public List<VehicleEntity> findbypricelessthan(@RequestParam Double price){
        return service.findByPriceLessthan(price);
    }
}
