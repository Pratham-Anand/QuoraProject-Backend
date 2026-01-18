package com.example.quoraproject.controllers;

import com.example.quoraproject.dtos.ApiResponse;
import com.example.quoraproject.dtos.CommentResponse;
import com.example.quoraproject.dtos.addCommentToCommentRequest;
import com.example.quoraproject.models.Comments;
import com.example.quoraproject.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }


    @PostMapping("/{commentId}/comments")
    private ResponseEntity<ApiResponse<Object>> addCommentToComment(@PathVariable UUID commentId, @Valid @RequestBody addCommentToCommentRequest dto){
        Comments comment=this.commentService.addCommentToComment(commentId,dto);

        CommentResponse responseDto=CommentResponse.builder()
                .commentId(comment.getCommentId())
                .text(comment.getText())
                .parent_comment(comment.getParent().getText())
                .answer(comment.getAnswer().getText())
                .userId(comment.getUser().getUserId())
                .userName(comment.getUser().getUsername())
                .build();

        ApiResponse<Object> response=new ApiResponse<>(true,"Comment posted successfully",responseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
