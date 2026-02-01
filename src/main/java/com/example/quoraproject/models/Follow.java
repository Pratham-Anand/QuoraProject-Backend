package com.example.quoraproject.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(
        name="follows",
        uniqueConstraints={
                @UniqueConstraint(columnNames= {"follower_id" , "followee_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follow extends BaseModel {

    @Column(nullable=false, updatable=false)
    private UUID followId;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="follower_id",nullable=false)
    private User follower;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="followee_id",nullable=false)
    private User followee;

    @PrePersist
    void generateUUID(){
        this.followId=UUID.randomUUID();
    }
}
