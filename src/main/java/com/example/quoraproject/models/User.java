package com.example.quoraproject.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User extends BaseModel {

    @Column(nullable=false,unique=true,updatable=false)
    private UUID userId;

    @Column(nullable=false,unique=true)
    private String username;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(length=500)
    private String bio;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isVerified;

    @Column(nullable = false)
    private boolean isActive;

    @PrePersist
    void generateUuid(){
        this.userId=UUID.randomUUID();
    }

}
