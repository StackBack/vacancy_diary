package com.vacancy.demo.service.impl;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.repository.UserRepository;
import com.vacancy.demo.service.AuthService;
import com.vacancy.demo.util.mapper.SourceDestinationMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SourceDestinationMapper mapper;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SourceDestinationMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public CustomUser saveUser(RegistrationRequest registrationRequest) {
        CustomUser user = mapper.convertRegistrationUser(registrationRequest);
//        CustomUser user = new CustomUser();
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public CustomUser loginUser(LoginRequest loginRequest) {
        CustomUser user = mapper.convertLoginRequest(loginRequest);
        return user;
    }
}
