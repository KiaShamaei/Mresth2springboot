package com.example.demo.controller;


import com.example.demo.model.Users;
import com.example.demo.repository.UserRepo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    final
    UserRepo userRepo ;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(path = "/users")
    public List getAllUsers (){
        return  userRepo.findAll();
    }
}
