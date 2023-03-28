package com.pruebastecnicas.backend.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void createUserVoid() {
        User newUser = new User();
        newUser.setUserName("Usuario 1");
        assertEquals("Usuario 1", newUser.getUserName());
    }

    @Test
    void createUserWhithArguments() {
        User newUser = new User(null, "Usuario 2", "password 02", null);
        assertEquals("Usuario 2", newUser.getUserName());
    }
}