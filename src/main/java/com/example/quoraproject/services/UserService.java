package com.example.quoraproject.services;

import com.example.quoraproject.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User createUser(User user);



}
