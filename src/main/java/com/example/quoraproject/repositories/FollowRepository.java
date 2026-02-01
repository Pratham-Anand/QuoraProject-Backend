package com.example.quoraproject.repositories;

import com.example.quoraproject.models.Follow;
import com.example.quoraproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {

    @Query(
            value = """
        SELECT *
        FROM follows f WHERE f.follower_id = :userId AND f.followee_id = :followeeId
    """, nativeQuery = true
    )
    Optional<Follow> findByUserAndFollowee(
            @Param("userId") Long userId,
            @Param("followeeId") Long followeeId
    );

}
