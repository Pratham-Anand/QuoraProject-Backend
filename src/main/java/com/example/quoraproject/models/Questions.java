package com.example.quoraproject.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

//    private S topics

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @PrePersist
    void generateUuid(){
        this.questionId=UUID.randomUUID();
    }
}
