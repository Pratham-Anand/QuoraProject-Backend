package com.example.quoraproject.models;

import com.example.quoraproject.models.enums.TargetType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "likes")
public class Like extends BaseModel{

    @Column(nullable=false,updatable=false)
    private UUID likeId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @Column(nullable=false)
    private UUID targetId;

    @Enumerated
    @Column(nullable=false)
    private TargetType targetType;

    @PrePersist
    void generateUUID(){
        this.likeId=UUID.randomUUID();
    }

}
