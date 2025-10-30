package com.example.Car.Rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleEntity {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String VehicleType;
    private String brand;
    private Double pricePerDay;
    private Boolean available;

}
