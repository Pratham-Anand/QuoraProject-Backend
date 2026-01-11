package com.example.quoraproject.services;

import com.example.quoraproject.dtos.AddTopicDto;
import com.example.quoraproject.models.Topic;
import com.example.quoraproject.repositories.TopicsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImp implements TopicService{

    private final TopicsRepository topicsRepository;

    private TopicServiceImp(TopicsRepository topicsRepository){
        this.topicsRepository=topicsRepository;
    }

    @Override
    public Topic addTopic(AddTopicDto dto) {

        Topic topic=Topic.builder()
                .name(dto.getName())
                .build();

        return topicsRepository.save(topic);
    }

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topics=topicsRepository.findAll();

        return topics;
    }
}
