package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerResponse {

    private UUID answerId;
    private String text;

    private UserSummaryDto user;
    private QuestionSummary question;
}
