package com.kongallis.blog.service;

import com.kongallis.blog.dto.RegisterRequest;
import com.kongallis.blog.models.User;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
    }
}
