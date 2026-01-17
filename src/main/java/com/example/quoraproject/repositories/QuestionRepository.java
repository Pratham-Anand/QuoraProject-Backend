package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {


    List<Questions> findQuestionsByQuestionId(UUID questionId);

    Questions findByQuestionId(UUID questionId);
}
