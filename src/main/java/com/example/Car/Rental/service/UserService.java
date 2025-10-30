package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.UserEntity;
import com.example.Car.Rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JWTservice jwTservice;

    @Autowired
    UserRepository repository;

    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
    public boolean deleteAll(){
        repository.deleteAll();
        return false;
    }

    public UserEntity findByUserName(String username){
        return repository.findByUsername(username);
    }

    public String verifyUser(UserEntity user){
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if (authentication.isAuthenticated()){
            return jwTservice.generateToken(user.getUsername());
        }
        return "invalid JWT Token";
    }
}
