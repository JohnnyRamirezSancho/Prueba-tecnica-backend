package com.pruebastecnicas.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebastecnicas.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    public Optional<Role> findByRole(String role);
    
}