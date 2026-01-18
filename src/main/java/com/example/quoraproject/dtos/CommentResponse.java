package com.example.quoraproject.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {

    private UUID commentId;
    private String text;
    private String answer;
    private String parent_comment;
    private UUID userId;
    private String userName;
}
