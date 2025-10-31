package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Booking_repo extends JpaRepository<BookingEntity,Integer> {
    public List<BookingEntity> findByUserId (Integer id);
}
