package com.example.Car.Rental.controller;


import com.example.Car.Rental.service.AdminDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class AdminDashboardController {

    @Autowired
    private AdminDashboard dashboard;

    @GetMapping("/vehicle-count")
    public Long getVehicleCount(){
        return dashboard.getCountVehicle();
    }

    @GetMapping("/booking-count")
    public Long getBookingCount(){
        return dashboard.getCountUser();
    }
    @GetMapping("/total-revenue")
    public double getTotalRevenue(){
        return dashboard.getBookingRevenue();
    }

}
