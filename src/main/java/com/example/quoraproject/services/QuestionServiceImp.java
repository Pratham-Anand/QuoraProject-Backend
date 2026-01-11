package com.example.quoraproject.services;

import com.example.quoraproject.dtos.AddQuestionRequest;
import com.example.quoraproject.models.Questions;
import com.example.quoraproject.models.Topic;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.QuestionRepository;
import com.example.quoraproject.repositories.TopicsRepository;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {


    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private TopicsRepository topicsRepository;

    public QuestionServiceImp(QuestionRepository questionRepository, UserRepository userRepository,TopicsRepository topicsRepository){
        this.questionRepository=questionRepository;
        this.userRepository=userRepository;
        this.topicsRepository=topicsRepository;

    }

    public Questions addQuestion(AddQuestionRequest dto){

        User user= userRepository.findUsersByUserId(dto.getUserId());
        if(user==null) throw new RuntimeException("User not found");

        List<Topic> topics = topicsRepository.findAllByTopicId(dto.getTopicIds());
//        System.out.println(topics);
        if (topics.size() != dto.getTopicIds().size())
            throw new RuntimeException("One or more topics not found");

        Questions question= Questions.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .user(user)
                .topics(topics)
                .build();
        return questionRepository.save(question);
    }

}
