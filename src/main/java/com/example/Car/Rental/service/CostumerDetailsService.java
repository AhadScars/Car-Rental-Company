package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.UserEntity;
import com.example.Car.Rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Car.Rental.entity.userPrinciple;

@Service
public class CostumerDetailsService implements UserDetailsService  {

    @Autowired
    UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);

        if (user == null)   {
            throw new UsernameNotFoundException("username Not Found");
        }
        return new userPrinciple(user);
    }
}
