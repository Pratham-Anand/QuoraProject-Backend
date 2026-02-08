package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.SignupRequest;
import com.example.quoraproject.dtos.SignupResponse;
import com.example.quoraproject.services.AuthService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private  AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Object>> signUp(@Valid @RequestBody SignupRequest request){

        SignupResponse response=authService.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true,"Signup successful", response));
    }




}
