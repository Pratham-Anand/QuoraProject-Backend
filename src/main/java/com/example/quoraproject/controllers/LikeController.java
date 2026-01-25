package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.LikeRequest;
import com.example.quoraproject.dtos.LikeResponse;
import com.example.quoraproject.models.Like;
import com.example.quoraproject.models.enums.TargetType;
import com.example.quoraproject.services.LikeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LikeController {

    private LikeService likeService;
    public LikeController(LikeService likeService){
        this.likeService=likeService;
    }

    @PostMapping("/{targetType}/{id}/likes")
    private ResponseEntity<ApiResponse<Object>> addLike(@PathVariable String targetType, @PathVariable UUID id , @Valid @RequestBody LikeRequest dto){
        TargetType type;
        try {
            type = TargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid target type: " + targetType);
        }

        Like like=this.likeService.addLike(dto.getUserId(),type,id);
        LikeResponse responseDto=LikeResponse.builder()
                .likeId(like.getLikeId())
                .userId(like.getUser().getUserId())
                .userName(like.getUser().getUsername())
                .targetType(like.getTargetType().name())
                .targetId(like.getTargetId())
                .build();

        ApiResponse<Object> response=new ApiResponse<>(true,"Liked successfully",responseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
