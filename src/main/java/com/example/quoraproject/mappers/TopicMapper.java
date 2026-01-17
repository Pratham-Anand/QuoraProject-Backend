package com.example.quoraproject.mappers;


import com.example.quoraproject.dtos.TopicResponse;
import com.example.quoraproject.dtos.UserSummaryDto;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.models.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {

    public TopicResponse topicResponse(Topic topic){
        return TopicResponse.builder()
                .topicId(topic.getTopicId())
                .name(topic.getName())
                .questions(
                        topic.getQuestions().stream()
                                .map(this::toQuestionResponse)
                                .toList()
                )
                .build();
    }

    private TopicResponse.QuestionResponse toQuestionResponse( Questions q){
        return TopicResponse.QuestionResponse.builder()
                .questionId(q.getQuestionId())
                .title(q.getTitle())
                .body(q.getBody())
                .user(
                UserSummaryDto.builder()
                        .userId(q.getUser().getUserId())
                        .name(q.getUser().getUsername())
                        .build()
        )
                .build();
    }
    }
