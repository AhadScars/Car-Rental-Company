package com.example.Car.Rental.controller;

import com.example.Car.Rental.entity.UserEntity;
import com.example.Car.Rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/show")
    public ResponseEntity<?> getAll(){
        List<UserEntity> user = service.getAll();
        if (user.isEmpty()){
            new ResponseEntity<>("No User Found ", HttpStatus.NO_CONTENT);
        }
           return new ResponseEntity<>(user,HttpStatus.OK);
        }

    @PostMapping("/add")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user){
        UserEntity User = service.saveUser(user);
        return new ResponseEntity<>("User save Succesfull" , HttpStatus.CREATED);
    }


    @DeleteMapping("delete")
    public ResponseEntity<?> deleteAll() {
        boolean isDeleted = service.deleteAll();

        if (isDeleted) {
            return new ResponseEntity<>("All items deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No items to delete", HttpStatus.NOT_FOUND);
        }
    }

}
