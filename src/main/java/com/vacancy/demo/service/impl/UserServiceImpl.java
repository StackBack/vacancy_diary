package com.vacancy.demo.service.impl;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.RegistrationRequest;
import com.vacancy.demo.exception.UserException;
import com.vacancy.demo.repository.UserRepository;
import com.vacancy.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User doesn`t find by id + " + id));
    }

    @Override
    public void updateUser(CustomUser customUser) {
        CustomUser customUser1 = userRepository.findById(customUser.getId())
                .orElseThrow(() -> new UserException("F"));
        userRepository.save(customUser1);

//                .map(user -> {
//                    user.setEmail(customUser.getEmail());
//                    user.setPassword(passwordEncoder.encode(customUser.getPassword()));
//                    userRepository.save(user);
//            return user;
        };

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
