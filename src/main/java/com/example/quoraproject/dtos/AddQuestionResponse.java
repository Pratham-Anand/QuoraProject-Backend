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
    private List<Topic> topics;
}
