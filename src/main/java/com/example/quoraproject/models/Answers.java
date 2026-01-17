package com.example.quoraproject.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answers extends BaseModel {

    @Column(nullable=false,updatable = false)
    private UUID answerId;


    @Column(nullable = false,length = 2000)
    private String text;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id",nullable = false)
    private Questions question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @PrePersist
    void generateUUID(){
        this.answerId=UUID.randomUUID();
    }


}
