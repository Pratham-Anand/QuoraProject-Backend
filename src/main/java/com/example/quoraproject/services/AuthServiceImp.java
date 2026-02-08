package com.example.quoraproject.services;

import com.example.quoraproject.dtos.SignupRequest;
import com.example.quoraproject.dtos.SignupResponse;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImp(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
    }

    @Override
    public SignupResponse signUp(SignupRequest request){

        if(userRepository.existsUserByEmail(request.getEmail()))
            throw new RuntimeException("Email already registered");

        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("Username already exists");

        User user=User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isVerified(false)
                .isActive(true)
                .build();

        userRepository.save(user);

        return SignupResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email((user.getEmail()))
                .isVerified((user.getIsVerified()))
                .build();

    }
}
