package com.example.quoraproject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class addCommentToAnswerRequest {

    @NotBlank(message = "Text field cannot be empty")
    private String text;

    @NotNull(message = "userId field cannot be null")
    private UUID userId;
}
