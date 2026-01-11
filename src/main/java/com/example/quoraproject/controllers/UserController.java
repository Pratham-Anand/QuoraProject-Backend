package com.example.quoraproject.controllers;
import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.CreateUserDto;
import com.example.quoraproject.models.User;
import com.example.quoraproject.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping
    private ResponseEntity<ApiResponse<User>> addUser(@Valid @RequestBody CreateUserDto request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .bio(request.getBio())
                .build();

        User savedUser=this.userService.createUser(user);
        ApiResponse<User> response =new ApiResponse<>(true,"User created successfully",savedUser);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    private ResponseEntity<List<User>> getUsers(){

        List<User> users=this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
