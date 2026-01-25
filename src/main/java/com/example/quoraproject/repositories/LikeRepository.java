package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    @Query(
            value = "SELECT * FROM likes l WHERE l.user_id = :userId AND l.target_id = :targetId",
            nativeQuery = true
    )
   Optional<Like> findByUserAndTarget(Long userId, UUID targetId);
}

