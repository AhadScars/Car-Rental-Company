package com.example.Car.Rental.controller;

import com.example.Car.Rental.entity.vehicle_Entity;
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
        List<vehicle_Entity> showAll = service.getAll();
        if (showAll.isEmpty()){
            new ResponseEntity<>("Vehicle IS Empty", HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(showAll, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> AddVehicle(@RequestBody vehicle_Entity vehicleEntity){
        vehicle_Entity Vehicle = service.addVehicle(vehicleEntity);
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
    public vehicle_Entity findById(@PathVariable Integer id){
        return service.findBYid(id);
    }

    @PutMapping("/edit/{id}")
    public vehicle_Entity editVehicle(@PathVariable Integer id, @RequestBody vehicle_Entity entity){
        return service.editvehicle(id,entity);
    }

    @GetMapping("/find/{name}")
    public List<vehicle_Entity> findByName(@PathVariable String name){
        return service.findByname(name);
    }

    @GetMapping("/available")
    public List<vehicle_Entity> findByAvailable(@RequestParam Boolean available){
        return service.findByAvailable(available);
    }

    @GetMapping("/")
    public List<vehicle_Entity> findbypricelessthan(@RequestParam Double price){
        return service.findByPriceLessthan(price);
    }
}
