package com.vacancy.demo.service.impl;

import com.vacancy.demo.domain.CustomUser;
import com.vacancy.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CustomUser> userOptional = userRepository.findByEmail(email);
        CustomUser user = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
                        "Found with email : " + email));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), true,
                true, true, true, Collections.emptyList());
    }
}
