package com.vacancy.demo.util.mapper;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.dto.UpdateInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    CustomUser convertRegistrationUser(RegistrationRequest registrationRequest);
    CustomUser convertInfoUser(UpdateInfo updateInfo);
    CustomUser convertLoginRequest(LoginRequest loginRequest);
}
