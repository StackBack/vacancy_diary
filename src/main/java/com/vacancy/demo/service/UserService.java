package com.vacancy.demo.service;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.RegistrationRequest;

public interface UserService {
    CustomUser getUserById(Long id);
    void updateUser(CustomUser customUser);
    void deleteUser(Long id);
}
