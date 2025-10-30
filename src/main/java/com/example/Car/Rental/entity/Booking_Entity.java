package com.example.Car.Rental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking_Entity {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;

    @PrePersist
    @PreUpdate
    private void calculateAmount() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        Double pricePerDay = vehicle.getPricePerDay();
        this.amount = days * pricePerDay;
    }
}
