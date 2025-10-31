package com.example.Car.Rental.service;
import com.example.Car.Rental.entity.BookingEntity;
import com.example.Car.Rental.repository.Booking_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Booking_Service {

    @Autowired
    Booking_repo repo;

    public List<BookingEntity> getAll(){
        return repo.findAll();
    }

    public BookingEntity addBooking(BookingEntity entity){
        return repo.save(entity);
    }

    public void deleteAll (){
        repo.deleteAll();
    }

    public Optional<BookingEntity> findById(Integer id) {
        return repo.findById(id);
    }

    public List<BookingEntity> findByUserId(Integer id){
        return repo.findByUserId(id);
    }
}
