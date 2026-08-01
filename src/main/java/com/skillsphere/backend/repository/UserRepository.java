package com.skillsphere.backend.repository;

import com.skillsphere.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillsphere.backend.dto.LoginRequest;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}