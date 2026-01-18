package com.example.quoraproject.models;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.stream.events.Comment;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments extends BaseModel{

    @Column(nullable=false,updatable=false)
    private UUID commentId;

    @Column(nullable=false,length=1000)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="answer_id",nullable = false)
    private Answers answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Comments parent;


    @PrePersist
    void generateUUID(){
        this.commentId=UUID.randomUUID();
    }

}
