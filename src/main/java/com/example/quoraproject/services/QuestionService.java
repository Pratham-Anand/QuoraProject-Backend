package com.example.quoraproject.services;

import com.example.quoraproject.dtos.AddQuestionRequest;
import com.example.quoraproject.models.Questions;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    public Questions addQuestion(AddQuestionRequest dto);

}
