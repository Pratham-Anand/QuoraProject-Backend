package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeResponse {

 private UUID likeId;
 private String targetType;
 private UUID targetId;
 private UUID userId;
 private String userName;

}
