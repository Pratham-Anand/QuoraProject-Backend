package com.example.quoraproject.services;


import com.example.quoraproject.models.*;
import com.example.quoraproject.models.enums.TargetType;
import com.example.quoraproject.repositories.*;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

import static com.example.quoraproject.models.enums.TargetType.*;

@Service
@Transactional
public class LikeServiceImp implements LikeService {

    private final QuestionRepository questionRepository;
    private final CommentRepository commentRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    public LikeServiceImp(QuestionRepository questionRepository, CommentRepository commentRepository,AnswerRepository answerRepository,UserRepository userRepository,LikeRepository likeRepository){
        this.questionRepository=questionRepository;
        this.commentRepository=commentRepository;
        this.answerRepository=answerRepository;
        this.userRepository=userRepository;
        this.likeRepository=likeRepository;
    }

    @Override
    public Like addLike(UUID userId, TargetType targetType, UUID targetId){

        User user= userRepository.findUsersByUserId(userId);

        if(targetType==QUESTION){
            Questions question=questionRepository.findByQuestionId(targetId);
            if(question==null) throw new RuntimeException("This question does not exist");
            question.setLikeCount(question.getLikeCount()+1);
            questionRepository.save(question);
        }
        else if(targetType==COMMENT){
            Comments comment=commentRepository.findByCommentId(targetId);
            if(comment==null) throw new RuntimeException("This comment does not exist");
            comment.setLikeCount(comment.getLikeCount()+1);
            commentRepository.save(comment);
        }
        else if(targetType==ANSWER){
            Answers answer=answerRepository.findByAnswerId(targetId);
            if(answer==null) throw new RuntimeException(("This answer does not exist"));
            answer.setLikeCount(answer.getLikeCount()+1);
        }

        Optional<Like> alreadyExist=likeRepository.findByUserAndTarget(user.getId(),targetId);
        if (alreadyExist.isPresent()) throw new RuntimeException("Already liked");


        Like like=Like.builder()
                .targetType(targetType)
                .targetId(targetId)
                .user(user)
                .build();

        return likeRepository.save(like);

    }

    @Override
    public void unLike(UUID userId,TargetType targetType,UUID targetId){

        User user=userRepository.findUsersByUserId(userId);
        Like like=likeRepository.findByUserAndTarget(user.getId(),targetId)
                .orElseThrow(()-> new RuntimeException("Like not found"));

        likeRepository.delete(like);

        if(targetType==QUESTION){
            Questions question=questionRepository.findByQuestionId(targetId);
            if(question==null) throw new RuntimeException("This question does not exist");
            question.setLikeCount(question.getLikeCount()-1);
            questionRepository.save(question);
        }
        else if(targetType==COMMENT){
            Comments comment=commentRepository.findByCommentId(targetId);
            if(comment==null) throw new RuntimeException("This comment does not exist");
            comment.setLikeCount(comment.getLikeCount()-1);
            commentRepository.save(comment);
        }
        else if(targetType==ANSWER){
            Answers answer=answerRepository.findByAnswerId(targetId);
            if(answer==null) throw new RuntimeException(("This answer does not exist"));
            answer.setLikeCount(answer.getLikeCount()-1);
        }

    }
}
