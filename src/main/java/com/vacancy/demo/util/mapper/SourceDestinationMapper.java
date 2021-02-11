package com.vacancy.demo.util.mapper;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.LoginRequest;
import com.vacancy.demo.dto.RegistrationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SourceDestinationMapper {
    CustomUser convertRegistrationUser(RegistrationRequest registrationRequest);
    CustomUser convertLoginRequest(LoginRequest loginRequest);
}
