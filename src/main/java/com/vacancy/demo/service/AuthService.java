package com.vacancy.demo.service;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;

public interface AuthService {
    CustomUser saveUser(RegistrationRequest customUser);
    CustomUser loginUser(LoginRequest loginRequest);
}
