package com.example.quoraproject.services;

import com.example.quoraproject.dtos.addCommentToAnswerRequest;
import com.example.quoraproject.dtos.addCommentToCommentRequest;
import com.example.quoraproject.models.Comments;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CommentService {

    public Comments addCommentToAnswer(UUID answerId, addCommentToAnswerRequest dto);
    public Comments addCommentToComment(UUID commentId, addCommentToCommentRequest dto);
}
