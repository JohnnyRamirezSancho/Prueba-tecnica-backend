package com.pruebastecnicas.backend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pruebastecnicas.backend.models.User;
import com.pruebastecnicas.backend.services.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    @WithMockUser("userTest")
    public void testListAll() throws Exception {

        List<User> users = new ArrayList<User>();
        User user1 = new User();
        User user2 = new User();

        users.add(user1);
        users.add(user2);

        when(service.listAll()).thenReturn(users);
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();
        
        assertEquals(response.getStatus(), 200);
        assertEquals(response.getContentAsString(), mapper.writeValueAsString(users));
    }}
