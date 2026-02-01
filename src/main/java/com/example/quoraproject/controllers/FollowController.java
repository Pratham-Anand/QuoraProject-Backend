package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.repositories.FollowRepository;
import com.example.quoraproject.services.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/follow/{followeeId}")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService){
        this.followService=followService;
    }

    @PostMapping()
    private ResponseEntity<ApiResponse<Object>>followUser(@PathVariable UUID userId, @PathVariable UUID followeeId){

        this.followService.followUser(userId,followeeId);

        ApiResponse<Object> response=new ApiResponse<>(true,"Followed successfully",null);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping
    private ResponseEntity<ApiResponse<Object>>unfollowUser(@PathVariable UUID userId,@PathVariable UUID followeeId){

        this.followService.unfollowUser(userId,followeeId);

        ApiResponse<Object> response=new ApiResponse<>(true,"Unfollowed Successfully",null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
