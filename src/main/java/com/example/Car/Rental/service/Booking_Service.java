package com.example.Car.Rental.service;
import com.example.Car.Rental.entity.Booking_Entity;
import com.example.Car.Rental.repository.Booking_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Booking_Service {

    @Autowired
    Booking_repo repo;

    public List<Booking_Entity> getAll(){
        return repo.findAll();
    }

    public Booking_Entity addBooking(Booking_Entity entity){
        return repo.save(entity);
    }

    public void deleteAll (){
        repo.deleteAll();
    }

}
