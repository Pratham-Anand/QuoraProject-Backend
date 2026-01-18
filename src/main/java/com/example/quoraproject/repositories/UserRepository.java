package com.example.quoraproject.repositories;

import com.example.quoraproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Component
public interface UserRepository extends JpaRepository<User,Long> {

    User findUsersByUserId(UUID userId);

    Boolean existsUserByEmail(String email);


}
