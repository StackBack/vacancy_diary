package com.vacancy.demo.dto;

import com.vacancy.demo.domain.Role;
import com.vacancy.demo.util.annotation.ValidPassword;
import lombok.Getter;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class RegistrationRequest {
    @Email
    private String email;
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String lastName;
    private String number;
    private String skype;
    private Role role;
    @ValidPassword
    private String password;
    @Transient
    private String confirmPassword;
}
