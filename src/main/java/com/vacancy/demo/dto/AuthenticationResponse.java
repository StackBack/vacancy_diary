package com.vacancy.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class AuthenticationResponse {
    private String authenticationToken;
    private Instant expiresAt;
    private String email;
}
