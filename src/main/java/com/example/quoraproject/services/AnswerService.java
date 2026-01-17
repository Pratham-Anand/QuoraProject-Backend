package com.example.quoraproject.services;

import com.example.quoraproject.dtos.addAnswerRequest;
import com.example.quoraproject.dtos.editAnswerRequest;
import com.example.quoraproject.models.Answers;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface AnswerService {
    public Answers addAnswer(UUID questionId, addAnswerRequest dto);
    public Answers editAnswer(UUID answerId, editAnswerRequest dto);

}
