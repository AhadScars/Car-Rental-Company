package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.UserEntity;
import com.example.Car.Rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserEntity> getAll(){
        return repository.findAll();
    }
    public UserEntity saveUser(UserEntity user){
        return repository.save(user);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
