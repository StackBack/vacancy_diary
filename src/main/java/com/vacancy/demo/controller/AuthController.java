package com.vacancy.demo.controller;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.AuthenticationResponse;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public CustomUser signUp(@RequestBody @Valid RegistrationRequest registrationRequest){
        return authService.saveUser(registrationRequest);
    }

    @PostMapping("/signin")
    public AuthenticationResponse signIn(@RequestBody @Valid LoginRequest loginRequest){
        return authService.loginUser(loginRequest);
    }
}
