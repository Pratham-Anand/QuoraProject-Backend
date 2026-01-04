package com.example.quoraproject.services;

import com.example.quoraproject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    public List<User> getAllUsers();



}
