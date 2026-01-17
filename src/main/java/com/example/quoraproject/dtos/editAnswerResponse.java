package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class editAnswerResponse {

    private UUID answerId;
    private String text;

    private String username;
    private UUID userID;
}
