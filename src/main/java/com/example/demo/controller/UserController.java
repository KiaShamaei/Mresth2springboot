package com.example.demo.controller;


import com.example.demo.model.Users;
import com.example.demo.repository.UserRepo;

import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping(path= "/user/{id}")
    public Optional<Users> getUser(@PathVariable Integer id){
        return userRepo.findById(id);
    }
    @RequestMapping(path = "/user/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
    }
    @RequestMapping(path= "user" , method = RequestMethod.POST)
    public Users editSaveUser (@RequestBody Users user){
        return userRepo.save(user);
    }
}
