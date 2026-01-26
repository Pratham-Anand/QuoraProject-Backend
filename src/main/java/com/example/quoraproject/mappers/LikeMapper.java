package com.example.quoraproject.mappers;

import com.example.quoraproject.dtos.LikeResponse;
import com.example.quoraproject.models.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper {

    public LikeResponse toResponse(Like like){

        return LikeResponse.builder()
                .likeId(like.getLikeId())
                .userId(like.getUser().getUserId())
                .userName(like.getUser().getUsername())
                .targetType(like.getTargetType().name())
                .targetId(like.getTargetId())
                .build();


    }
}
