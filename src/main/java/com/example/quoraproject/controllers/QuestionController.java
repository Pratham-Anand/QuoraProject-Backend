package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.AddQuestionRequest;
import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.services.QuestionService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    private QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }



    @PostMapping
    private ResponseEntity<ApiResponse<Object>> addQuestion(@Valid @RequestBody AddQuestionRequest dto){
        Questions  question=this.questionService.addQuestion(dto);

        ApiResponse<Object> response=new ApiResponse<>(true,"Question created successfully",question);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }





}
