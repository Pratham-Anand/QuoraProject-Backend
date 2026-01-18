package com.example.quoraproject.controllers;


import com.example.quoraproject.dtos.*;
import com.example.quoraproject.mappers.TopicMapper;
import com.example.quoraproject.models.Topic;
import com.example.quoraproject.services.TopicService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicMapper topicMapper;
    private TopicService topicService;

    private TopicController(TopicService topicService, TopicMapper topicMapper){
        this.topicService=topicService;
        this.topicMapper = topicMapper;
    }


    @PostMapping
    private ResponseEntity<ApiResponse<Object>> addTopic(@Valid @RequestBody AddTopicDto dto){

        Topic topic =this.topicService.addTopic(dto);

        ApiResponse<Object> response=new ApiResponse<>(true,"Topic added successfully",topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    private ResponseEntity<ApiResponse<Object>> getAllTopics(){
//        List<Topic> topics=this.topicService.getAllTopics();


//        List<TopicResponse> dtoResponse = topics.stream()
//                .map(topic -> TopicResponse.builder()
//                        .topicId(topic.getTopicId())
//                        .name(topic.getName())
//                        .questions(
//                                topic.getQuestions().stream()
//                                        .map(q -> TopicResponse.QuestionResponse.builder()
//                                                .questionId(q.getQuestionId())
//                                                .title(q.getTitle())
//                                                .body(q.getBody())
//                                                .user(UserSummaryDto.builder()
//                                                        .userId(q.getUser().getUserId())
//                                                        .name(q.getUser().getUsername())
//                                                        .build())
//                                                .build())
//                                        .toList()
//                        )
//                        .build())
//                .toList();

        List<TopicResponse> dtoResponse =topicService.getAllTopics()
                .stream()
                .map(topicMapper::topicResponse)
                .toList();



        ApiResponse<Object> response= new ApiResponse<>(true,"Topics fetched successfully", dtoResponse);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
