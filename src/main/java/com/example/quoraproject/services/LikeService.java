package com.example.quoraproject.services;

import com.example.quoraproject.models.Like;
import org.hibernate.tool.schema.TargetType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface LikeService {

    Like addLike(UUID userId, com.example.quoraproject.models.enums.TargetType targetType, UUID targetId);
}
