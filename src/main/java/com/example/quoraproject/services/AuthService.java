package com.example.quoraproject.services;

import com.example.quoraproject.dtos.SignupRequest;
import com.example.quoraproject.dtos.SignupResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public SignupResponse signUp(SignupRequest dto);

}
