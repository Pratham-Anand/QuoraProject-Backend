package com.example.quoraproject.controllers;


import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.editAnswerRequest;
import com.example.quoraproject.dtos.editAnswerResponse;
import com.example.quoraproject.models.Answers;
import com.example.quoraproject.services.AnswerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService){
        this.answerService=answerService;
    }

    @PutMapping("/{answerId}")
    ResponseEntity<ApiResponse<Object>> editAnswer(@PathVariable UUID answerId, @Valid @RequestBody editAnswerRequest dto){

        Answers answer= this.answerService.editAnswer(answerId,dto);

       editAnswerResponse dtoResponse=editAnswerResponse.builder()
               .text(answer.getText())
               .answerId(answer.getAnswerId())
               .userID(answer.getUser().getUserId())
               .username(answer.getUser().getUsername())
               .build();



        ApiResponse<Object> response=new ApiResponse<>(true,"Answer edited successfully",dtoResponse);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }




}
