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
public class addCommentToCommentRequest {

    @NotBlank(message="text field can't be empty")
    private String text;
    @NotNull(message = "userId is required")
    private UUID userId;
}
