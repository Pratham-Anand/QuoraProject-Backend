package com.example.quoraproject.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface FollowService {

    void followUser(UUID userId, UUID followeeId);
    void unfollowUser(UUID userId, UUID followeeId);




}
