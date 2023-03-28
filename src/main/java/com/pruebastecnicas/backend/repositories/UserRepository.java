package com.pruebastecnicas.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebastecnicas.backend.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}