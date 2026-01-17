package com.example.quoraproject.repositories;


import com.example.quoraproject.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answers,Long> {

    Answers findByAnswerId(UUID answerId);
}
