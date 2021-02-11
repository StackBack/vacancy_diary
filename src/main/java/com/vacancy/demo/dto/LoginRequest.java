package com.vacancy.demo.dto;

import com.vacancy.demo.util.annotation.ValidPassword;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class LoginRequest {
    @Email
    String email;
    @ValidPassword
    String password;
}
