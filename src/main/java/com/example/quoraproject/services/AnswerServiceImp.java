package com.example.quoraproject.services;

import com.example.quoraproject.dtos.addAnswerRequest;
import com.example.quoraproject.dtos.editAnswerRequest;
import com.example.quoraproject.models.Answers;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.AnswerRepository;
import com.example.quoraproject.repositories.QuestionRepository;
import com.example.quoraproject.repositories.UserRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AnswerServiceImp implements AnswerService{

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public AnswerServiceImp(UserRepository userRepository,QuestionRepository questionRepository, AnswerRepository answerRepository){
        this.answerRepository=answerRepository;
        this.questionRepository=questionRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Answers addAnswer(UUID questionId, addAnswerRequest dto){

        Questions question=questionRepository.findByQuestionId(questionId);
        if(question== null) throw new RuntimeException("Question not found");

        User user= userRepository.findUsersByUserId(dto.getUserId());
        if(user==null) throw new RuntimeException("User not found");

        Answers answer=Answers.builder()
                .text(dto.getText())
                .user(user)
                .question(question)
                .build();

        return answerRepository.save(answer);

    }

    @Override
    public Answers editAnswer(UUID answerId, editAnswerRequest dto){

        Answers answer=answerRepository.findByAnswerId(answerId);
        if(answer==null) throw new RuntimeException("This answer does not exist");

        answer.setText(dto.getText());

        return answerRepository.save(answer);
    }
}
