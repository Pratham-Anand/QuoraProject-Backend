package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.*;
import com.example.quoraproject.models.Answers;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.services.AnswerService;
import com.example.quoraproject.services.QuestionService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;
    private AnswerService answerService;

    private QuestionController(QuestionService questionService,AnswerService answerService){
        this.questionService=questionService;
        this.answerService=answerService;
    }



    @PostMapping
    private ResponseEntity<ApiResponse<Object>> addQuestion(@Valid @RequestBody AddQuestionRequest dto){
        Questions  question=this.questionService.addQuestion(dto);

        AddQuestionResponse responseDto = AddQuestionResponse.builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .body(question.getBody())
                .topics(question.getTopics().stream()
                        .map(t -> AddQuestionResponse.TopicResponse.builder()
                                .topicId(t.getTopicId())
                                .name(t.getName())
                                .build())
                        .toList())
                .user(AddQuestionResponse.UserResponse.builder()
                        .userId(question.getUser().getUserId())
                        .username(question.getUser().getUsername())
                        .email(question.getUser().getEmail())
                        .build())
                .build();

        ApiResponse<Object> response=new ApiResponse<>(true,"Question created successfully",responseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/{questionId}/answers")
    private ResponseEntity<ApiResponse<Object>> addAnswer(@PathVariable UUID questionId, @Valid @RequestBody addAnswerRequest dto){

        Answers answer = this.answerService.addAnswer(questionId,dto);
        AnswerResponse dtoResponse=AnswerResponse.builder()
                .answerId(answer.getAnswerId())
                .text(answer.getText())
                .user(UserSummaryDto.builder()
                        .userId(answer.getUser().getUserId())
                        .name(answer.getUser().getUsername())
                        .build())
                .question(QuestionSummary.builder()
                        .questionId(answer.getQuestion().getQuestionId())
                        .title(answer.getQuestion().getTitle())
                        .body(answer.getQuestion().getBody())
                        .build())
                .build();

        ApiResponse<Object> response=new ApiResponse<>(true,"Answer posted succuessfully",dtoResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);



    }




}
