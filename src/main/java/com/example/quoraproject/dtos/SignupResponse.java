package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupResponse {

    private UUID userId;
    private String username;
    private String email;
    private boolean isVerified;
}
