package com.pruebastecnicas.backend.services;

import org.springframework.stereotype.Service;

import com.pruebastecnicas.backend.models.Role;
import com.pruebastecnicas.backend.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role getOne(Long id) {
        Role role = repository.findById(id).orElse(null);
        return role;
    }

    public Role getOneByRole(String role) {
        Role roleFind = repository.findByRole(role).orElse(null);
        return roleFind;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Role save(Role role) {
        Role newRole=repository.save(role);
        return newRole;
    }
}
