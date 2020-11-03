package com.kongallis.blog.controllers;

import com.kongallis.blog.dto.LoginRequest;
import com.kongallis.blog.dto.RegisterRequest;
import com.kongallis.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity signup (@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public void login (@RequestBody LoginRequest loginRequest) {
        authService.login(loginRequest);
    }
}
