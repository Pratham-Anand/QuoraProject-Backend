package com.example.quoraproject.services;

import com.example.quoraproject.dtos.addCommentToAnswerRequest;
import com.example.quoraproject.dtos.addCommentToCommentRequest;
import com.example.quoraproject.models.Answers;
import com.example.quoraproject.models.Comments;
import com.example.quoraproject.models.User;
import com.example.quoraproject.repositories.AnswerRepository;
import com.example.quoraproject.repositories.CommentRepository;
import com.example.quoraproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImp implements CommentService{

    private final AnswerRepository answerRepository;
    private final CommentRepository commentRepository;
    private  UserRepository userRepository;

    public CommentServiceImp(CommentRepository commentRepository,AnswerRepository answerRepository,UserRepository userRepository){
        this.commentRepository=commentRepository;
        this.answerRepository=answerRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Comments addCommentToAnswer(UUID answerId, addCommentToAnswerRequest dto){

       Answers answer=answerRepository.findByAnswerId(answerId);
        if(answer==null) throw new RuntimeException("No such answer exists!");

       User user=userRepository.findUsersByUserId(dto.getUserId());

        Comments comment=Comments.builder()
                .answer(answer)
                .text(dto.getText())
                .user(user)
                .build();

        return commentRepository.save(comment);

    }

    @Override
    public Comments addCommentToComment(UUID commentId, addCommentToCommentRequest dto){

        Comments parentComment=commentRepository.findByCommentId(commentId);
        if(parentComment==null) throw new RuntimeException("Parent comment not found");

        User user=userRepository.findUsersByUserId(dto.getUserId());
        if(user==null) throw new RuntimeException("User not found");

        Comments comment=Comments.builder()
                .answer(parentComment.getAnswer())
                .text(dto.getText())
                .user(user)
                .parent(parentComment)
                .build();

        return commentRepository.save(comment);


    }





}
