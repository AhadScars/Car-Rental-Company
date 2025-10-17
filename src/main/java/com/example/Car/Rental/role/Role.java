package com.example.Car.Rental.role;

import jakarta.persistence.Enumerated;

public enum Role {
    @Enumerated
    ADMIN,
    USER;

}
