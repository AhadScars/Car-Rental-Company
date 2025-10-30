package com.example.Car.Rental.controller;


import com.example.Car.Rental.entity.Booking_Entity;
import com.example.Car.Rental.service.Booking_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/booking")
@RestController
public class Booking_Controller {

    @Autowired
    Booking_Service service;

    @GetMapping("/show")
    public ResponseEntity<?> showAll(){
        List<Booking_Entity> showAll = service.getAll();
        if (showAll.isEmpty()){
            new ResponseEntity<>("No Booking", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showAll,HttpStatus.OK);
    }


    @PostMapping("/add")
   public ResponseEntity<String> addBooking(@RequestBody Booking_Entity entity){
        Booking_Entity booking = service.addBooking(entity);
        return new ResponseEntity<>("Booking Added ", HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public void deleteAll (){
        service.deleteAll();
    }

    @GetMapping("/show/{id}")
    public Optional<Booking_Entity> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/{id}")
    public List<Booking_Entity> findByUserId (@PathVariable Integer id){
        return service.findByUserId(id);
    }


}
