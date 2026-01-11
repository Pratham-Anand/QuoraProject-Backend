package com.example.quoraproject.services;

import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{


    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    public User createUser(User user){

        if(userRepository.existsUserByEmail(user.getEmail())) throw new RuntimeException("This email already exists");
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
