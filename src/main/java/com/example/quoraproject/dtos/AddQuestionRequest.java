package com.example.quoraproject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddQuestionRequest {

    @NotBlank(message="Title is required")
    private String body;

    @NotBlank(message="Title is required")
    private String title;

    @NotNull(message="User uuid is required")
    private UUID userId;

}
