package com.example.quoraproject.services;

import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{


    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    public User createUser(User user){
        return userRepository.save(user);
    }
}
