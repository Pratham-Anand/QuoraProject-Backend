package com.example.quoraproject.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Questions extends BaseModel {

    @Column(nullable=false,updatable = false)
    private UUID questionId;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String body;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="question_topics",
            joinColumns = @JoinColumn(name="question_id"),
            inverseJoinColumns = @JoinColumn(name="topic_id")
    )
    private List<Topic> topics;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @PrePersist
    void generateUuid(){
        this.questionId=UUID.randomUUID();
    }
}
