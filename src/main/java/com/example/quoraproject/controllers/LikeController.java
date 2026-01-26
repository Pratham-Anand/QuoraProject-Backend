package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.LikeRequest;
import com.example.quoraproject.dtos.LikeResponse;
import com.example.quoraproject.mappers.LikeMapper;
import com.example.quoraproject.models.Like;
import com.example.quoraproject.models.enums.TargetType;
import com.example.quoraproject.services.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/{targetType}/{id}/likes")
public class LikeController {

    private LikeService likeService;

    @Autowired
    private LikeMapper likeMapper;
    public LikeController(LikeService likeService){
        this.likeService=likeService;
    }

    @PostMapping
    private ResponseEntity<ApiResponse<Object>> addLike(@PathVariable String targetType, @PathVariable UUID id , @Valid @RequestBody LikeRequest dto){
        TargetType type;
        try {
            type = TargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid target type: " + targetType);
        }

        Like like=this.likeService.addLike(dto.getUserId(),type,id);
        LikeResponse responseDto= likeMapper.toResponse(like);

        ApiResponse<Object> response=new ApiResponse<>(true,"Liked successfully",responseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    private ResponseEntity<ApiResponse<Object>>unLike(@PathVariable String targetType,@PathVariable UUID id,@Valid @RequestBody LikeRequest dto){
        TargetType type;
        try {
            type = TargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid target type: " + targetType);
        }

        this.likeService.unLike(dto.getUserId(),type,id);

        ApiResponse<Object> response=new ApiResponse<>(true,"Unliked Successfully",null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);





    }


}
