package com.vacancy.demo.repository;

import com.vacancy.demo.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByName(String name);
    Optional<CustomUser> findByEmail(String email);
}
