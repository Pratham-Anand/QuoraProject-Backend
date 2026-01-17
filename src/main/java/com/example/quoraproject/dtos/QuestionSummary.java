package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionSummary {

    private UUID questionId;
    private String title;
    private String body;
}
