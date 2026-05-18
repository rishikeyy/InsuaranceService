package com.example.authservice.service;

import com.example.authservice.cognito.CognitoClientService;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CognitoClientService cognitoClientService;

    public LoginResponse login(LoginRequest request) {

        return cognitoClientService.authenticate(
                request.getUsername(),
                request.getPassword()
        );
    }
}