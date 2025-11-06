package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.BookingEntity;
import com.example.Car.Rental.repository.Booking_repo;
import com.example.Car.Rental.repository.UserRepository;
import com.example.Car.Rental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDashboard {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Booking_repo bookingRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    public Long getCountUser(){
        return userRepository.count();
    }

    public Long getCountVehicle(){
        return vehicleRepo.count();
    }

    public double getBookingRevenue(){
        double totalrevenue = 0;
        for (BookingEntity bookingEntity : bookingRepo.findAll()){
            totalrevenue += bookingEntity.getAmount();
        }
        return totalrevenue;
    }
}
