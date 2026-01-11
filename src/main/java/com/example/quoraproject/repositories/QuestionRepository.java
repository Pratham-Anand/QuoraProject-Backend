package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {


}
