package com.example.quoraproject.repositories;

import com.example.quoraproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUsersByUserId(UUID userId);

}
