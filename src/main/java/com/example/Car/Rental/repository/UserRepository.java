package com.example.Car.Rental.repository;

import com.example.Car.Rental.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public UserEntity findByUsername(String username);

}
