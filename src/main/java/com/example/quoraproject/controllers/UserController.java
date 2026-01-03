package com.example.quoraproject.controllers;


import com.example.quoraproject.dtos.CreateUserDto;
import com.example.quoraproject.models.User;
import com.example.quoraproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping
    private ResponseEntity<User> addUser(@RequestBody CreateUserDto request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .bio(request.getBio())
                .build();

        User savedUser=this.userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }



}
