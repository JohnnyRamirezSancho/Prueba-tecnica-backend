package com.pruebastecnicas.backend.services;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebastecnicas.backend.models.Role;
import com.pruebastecnicas.backend.repositories.RoleRepository;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @InjectMocks
    RoleService service;

    @Mock
    RoleRepository repository;

    @Test
    void testGetAll() {
        Role roleUser = new Role(null, "ROLE_USER");
        Role roleAdmin = new Role(null, "ROLE_ADMIN");

        List<Role> roles = new ArrayList<>();

        roles.add(roleUser);
        roles.add(roleAdmin);

        when(repository.findAll()).thenReturn(roles);

        List<Role> reponseRolesTest = service.getAll();

        assertThat(reponseRolesTest.size()).isEqualTo(2);
        assertThat(reponseRolesTest.get(0).getRole()).isEqualTo("ROLE_USER");
    }

    @Test
    void testGetOne() {
        Role roleUser = new Role(null, "ROLE_USER");

        when(repository.findByRole("ROLE_USER")).thenReturn(Optional.of(roleUser));

        service.getOneByRole("ROLE_USER");

        assertThat(roleUser.getRole()).isEqualTo("ROLE_USER");
    }

    @Test
    void testDelete() {
        Role roleNew = new Role((long) 1, "ROLE_ADMIN");
        repository.save(roleNew);
        repository.deleteById(roleNew.getId_role());
        Optional<Role> optional = repository.findById((long) 1);
        assertEquals(Optional.empty(), optional);
    }
}
