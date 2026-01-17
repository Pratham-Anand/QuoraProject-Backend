package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class editAnswerRequest {

    private String text;
    private UUID userId;

}
