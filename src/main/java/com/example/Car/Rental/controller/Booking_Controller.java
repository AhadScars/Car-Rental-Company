package com.example.Car.Rental.controller;


import com.example.Car.Rental.entity.Booking_Entity;
import com.example.Car.Rental.service.Booking_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")
@RestController
public class Booking_Controller {

    @Autowired
    Booking_Service service;

    @GetMapping("/show")
    public List<Booking_Entity> getAll(){
        return service.getAll();
    }
    @PostMapping("/add")
    public Booking_Entity addBooking(@RequestBody Booking_Entity entity){
        return service.addBooking(entity);
    }

    @DeleteMapping("/all")
    public void deleteAll (){
        service.deleteAll();
    }


}
