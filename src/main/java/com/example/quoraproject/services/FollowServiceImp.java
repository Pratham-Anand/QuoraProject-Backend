package com.example.quoraproject.services;


import com.example.quoraproject.models.Follow;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.FollowRepository;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FollowServiceImp implements FollowService{

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public FollowServiceImp(UserRepository userRepository,FollowRepository followRepository){
        this.userRepository=userRepository;
        this.followRepository=followRepository;
    }

    @Override
    public void followUser(UUID userId, UUID followeeId){

        if(userId==followeeId){
            throw new RuntimeException("User can't follow itself");
        }

        User user= userRepository.findUsersByUserId(userId);
        if(user==null) throw new RuntimeException("User does not exist");

        User followee=userRepository.findUsersByUserId(followeeId);
        if(followee==null) throw new RuntimeException("Followee does not exist");

        Follow follow = Follow.builder()
                .follower(user)
                .followee(followee)
                .build();

         followRepository.save(follow);
    }

    @Override
    public void unfollowUser(UUID userId, UUID followeeId){

        if(userId==followeeId){
            throw new RuntimeException("User can't unfollow itself");
        }

        User user= userRepository.findUsersByUserId(userId);
        if(user==null) throw new RuntimeException("User does not exist");

        User followee=userRepository.findUsersByUserId(followeeId);
        if(followee==null) throw new RuntimeException("Followee does not exist");

        Optional<Follow> follow=followRepository.findByUserAndFollowee(user.getId(),followee.getId());
        if(follow.isEmpty()) throw new RuntimeException("This follow relatiom does not exist");
        else followRepository.delete(follow.get());



    }


}
