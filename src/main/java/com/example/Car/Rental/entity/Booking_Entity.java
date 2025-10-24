package com.example.Car.Rental.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Booking_Entity {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private vehicle_Entity vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;

    public Booking_Entity(Integer id, vehicle_Entity vehicle, UserEntity user, LocalDate startDate, LocalDate endDate, double amount) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public vehicle_Entity getVehicle() {
        return vehicle;
    }

    public void setVehicle(vehicle_Entity vehicle) {
        this.vehicle = vehicle;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Booking_Entity() {
    }
    @PrePersist
    @PreUpdate
    private void calculateAmount() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        Double pricePerDay = vehicle.getPricePerDay();
        this.amount = days * pricePerDay;
    }
}
