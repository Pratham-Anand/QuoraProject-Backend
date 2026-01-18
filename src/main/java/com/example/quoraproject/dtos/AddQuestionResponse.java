package com.example.quoraproject.dtos;

import com.example.quoraproject.models.Topic;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddQuestionResponse {

    private UUID questionId;
    private String title;
    private String body;
    private List<TopicResponse> topics;
    private UserResponse user;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TopicResponse {
        private UUID topicId;
        private String name;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserResponse{
        private UUID userId;
        private String username;
        private String email;
    }
}
