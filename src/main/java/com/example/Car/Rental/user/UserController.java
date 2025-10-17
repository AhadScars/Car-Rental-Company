package com.example.Car.Rental.user;

import com.example.Car.Rental.entity.UserEntity;
import com.example.Car.Rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/show")
    public List<UserEntity> getAll(){
        return service.getAll();
    }
    @PostMapping("/add")
    public UserEntity saveUser(UserEntity user){
        return service.saveUser(user);
    }
    @DeleteMapping("delete")
    public void deleteAll(){
        service.deleteAll();
    }

}
