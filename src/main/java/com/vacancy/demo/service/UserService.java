package com.vacancy.demo.service;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.dto.UpdateInfo;

public interface UserService {
    CustomUser getUserById(Long id);
    void updateUser(UpdateInfo updateInfo);
    void deleteUser(Long id);
}
