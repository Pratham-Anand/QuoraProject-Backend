package com.example.quoraproject.controllers;


import com.example.quoraproject.dtos.AddTopicDto;
import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.models.Topic;
import com.example.quoraproject.services.TopicService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private TopicService topicService;

    private TopicController(TopicService topicService){
        this.topicService=topicService;
    }


    @PostMapping
    private ResponseEntity<ApiResponse<Object>> addTopic(@Valid @RequestBody AddTopicDto dto){

        Topic topic =this.topicService.addTopic(dto);

        ApiResponse<Object> response=new ApiResponse<>(true,"Topic added successfully",topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    private ResponseEntity<ApiResponse<Object>> getAllTopics(){
        List<Topic> topics=this.topicService.getAllTopics();

        ApiResponse<Object> response= new ApiResponse<>(true,"Topics fetched successfully", topics);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
