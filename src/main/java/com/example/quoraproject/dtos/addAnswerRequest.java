package com.example.quoraproject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class addAnswerRequest {
    @NotBlank(message="text field is required")
    private String text;

    @NotNull(message="User id is required")
    private UUID userId;

}
