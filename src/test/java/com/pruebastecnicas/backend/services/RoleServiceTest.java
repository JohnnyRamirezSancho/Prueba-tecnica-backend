package com.pruebastecnicas.backend.services;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
 
        List<Role> roles = new ArrayList<>();
 
        roles.add(roleUser);
 
        when(repository.findAll()).thenReturn(roles);
 
        List<Role> reponseRolesTest = service.getAll();
 
        assertThat(reponseRolesTest.size()).isEqualTo(1);
        assertThat(reponseRolesTest.get(0).getRole()).isEqualTo("ROLE_USER");
     }

    @Test
    void testGetOne() {
        Role roleUser = new Role(null, "ROLE_USER");

        when(repository.findByRole("ROLE_USER").isPresent());
        
        service.getOneByRole("ROLE_USER");

        assertThat(roleUser.getRole()).isEqualTo("ROLE_USER");
    }

    @Test
    void testSave() {

    }

    @Test
    void testDelete() {

    }    

}
