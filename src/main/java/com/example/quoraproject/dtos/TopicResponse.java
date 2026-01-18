package com.example.quoraproject.dtos;

import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicResponse {

    private UUID topicId;
    private String name;
    private List<QuestionResponse> questions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class QuestionResponse{
        private UUID questionId;
        private String title;
        private String body;
        private UserSummaryDto user;
    }
}
