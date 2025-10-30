package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.Booking_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Booking_repo extends JpaRepository<Booking_Entity,Integer> {
    public List<Booking_Entity> findByUserId (Integer id);
}
