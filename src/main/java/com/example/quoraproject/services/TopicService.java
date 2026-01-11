package com.example.quoraproject.services;

import com.example.quoraproject.dtos.AddTopicDto;
import com.example.quoraproject.models.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {

    public Topic addTopic(AddTopicDto dto);
    public List<Topic> getAllTopics();
}
