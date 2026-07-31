package com.skillsphere.backend.service;

import com.skillsphere.backend.dto.RegisterRequest;
import com.skillsphere.backend.entity.User;
import com.skillsphere.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "Registration Successful";
    }
}