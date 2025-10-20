package com.example.Car.Rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class vehicle_Entity {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String VehicleType;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getVehicleType () {
        return VehicleType;
    }

    public void setVehicleType (String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public Double getPricePerDay () {
        return pricePerDay;
    }

    public void setPricePerDay (Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Boolean getAvailable () {
        return available;
    }

    public void setAvailable (Boolean available) {
        this.available = available;
    }

    private String brand;
    private Double pricePerDay;
    private Boolean available;

    public vehicle_Entity (Integer id, String name, String vehicleType, String brand, Double pricePerDay, Boolean available) {
        this.id = id;
        this.name = name;
        VehicleType = vehicleType;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    public vehicle_Entity () {
    }
}
