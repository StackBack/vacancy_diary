package com.vacancy.demo.service.impl;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.AuthenticationResponse;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.exception.AuthException;
import com.vacancy.demo.repository.UserRepository;
import com.vacancy.demo.service.AuthService;
import com.vacancy.demo.service.TokenService;
import com.vacancy.demo.util.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper mapper, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public CustomUser saveUser(RegistrationRequest registrationRequest) {
        CustomUser user = mapper.convertRegistrationUser(registrationRequest);
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public AuthenticationResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenService.createToken(loginRequest);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .expiresAt(Instant.now().plusMillis(tokenService.getJwtExpirationInMills()))
                .email(loginRequest.getEmail())
                .build();
    }

    @Override
    public CustomUser getCorrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByName(user.getUsername()).orElseThrow(() -> new AuthException("Something went wrong"));
    }
}
