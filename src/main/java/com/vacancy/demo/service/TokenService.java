package com.vacancy.demo.service;

import com.vacancy.demo.dto.LoginRequest;

public interface TokenService {
    String createToken(LoginRequest user);
    Long getUserIdFromToken(String token);
    boolean isTokenValid(String token);
    Long getJwtExpirationInMills();
}
