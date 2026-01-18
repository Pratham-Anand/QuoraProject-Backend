package com.example.quoraproject.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="topics")
public class Topic extends BaseModel{

    @Column(nullable = false,updatable = false)
    private UUID topicId;
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy="topics")
//    @JsonIgnore
    private List<Questions> questions;



    @PrePersist
    void generateUuid(){
        this.topicId=UUID.randomUUID();
    }

}
