package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comments,Long> {
  Comments findByCommentId(UUID commentId);

}
