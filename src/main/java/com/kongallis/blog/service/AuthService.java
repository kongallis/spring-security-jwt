package com.kongallis.blog.service;

import com.kongallis.blog.dto.RegisterRequest;
import com.kongallis.blog.models.User;
import com.kongallis.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());

        // Save object to the database
        userRepository.save(user);
    }
}
