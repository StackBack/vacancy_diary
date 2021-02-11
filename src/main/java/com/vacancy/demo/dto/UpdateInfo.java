package com.vacancy.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class UpdateInfo {
    @Email
    private String email;
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String lastName;
    private String number;
    private String skype;
    private String password;
}
