package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TopicsRepository extends JpaRepository<Topic,Long>{

    @Query(
            value = "SELECT * FROM topics t WHERE t.topic_id IN (:topicIds)",
            nativeQuery = true
    )
    public List<Topic> findAllByTopicId(@Param("topicIds")List<UUID> topicIds);

}
