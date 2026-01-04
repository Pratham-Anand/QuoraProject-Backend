package com.example.quoraproject.services;

import com.example.quoraproject.dtos.AddQuestionRequest;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.QuestionRepository;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService {


    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    public QuestionServiceImp(QuestionRepository questionRepository, UserRepository userRepository){
        this.questionRepository=questionRepository;
        this.userRepository=userRepository;
    }

    public Questions addQuestion(AddQuestionRequest dto){

        User user= userRepository.findUsersByUserId(dto.getUserId());
        if(user==null) throw new RuntimeException("User not found");

        Questions question= Questions.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .user(user)
                .build();
        return questionRepository.save(question);
    }

}
