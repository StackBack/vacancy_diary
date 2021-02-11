package com.vacancy.demo.service.impl;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.dto.UpdateInfo;
import com.vacancy.demo.exception.UserException;
import com.vacancy.demo.repository.UserRepository;
import com.vacancy.demo.service.UserService;
import com.vacancy.demo.util.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User doesn`t find by id + " + id));
    }

    @Override
    public void updateUser(UpdateInfo customUser) {
        CustomUser user = userRepository.findByEmail(customUser.getEmail()).map(userTemp -> {
            userTemp.setEmail(customUser.getEmail());
            userTemp.setName(customUser.getName());
            userTemp.setLastName(customUser.getLastName());
            userTemp.setPassword(passwordEncoder.encode(customUser.getPassword()));
            userTemp.setNumber(customUser.getNumber());
            userTemp.setSkype(customUser.getSkype());
//            userTemp = userMapper.convertInfoUser(customUser);
            userRepository.save(userTemp);
            return userTemp;
        }).orElseThrow(() -> new UserException("Invalid data"));
        };

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
