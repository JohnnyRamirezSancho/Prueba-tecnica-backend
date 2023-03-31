package com.events.upcoming.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.events.upcoming.models.Event;
import com.events.upcoming.models.Role;
import com.events.upcoming.models.User;
import com.events.upcoming.services.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/register/add", consumes = {"*/*"})
    public ResponseEntity<Map<String, String>> save(@RequestBody User user) {

        try {
            Role userRole = new Role();
            userRole.setId_role((long) 2);
            Set<Role> set = new HashSet<Role>();
            set.add(userRole);
            user.setRoles(set);
            User userDB = service.store(user);
            Map<String, String> json = new HashMap<>();

            json.put("username", userDB.getUserName());
            json.put("message", "successful sign up");
            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("prolem", e.getMessage());
            json.put("message", "Error to sign up");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }

    @PostMapping(value = "/register/{userName}/event/{id}")
    public ResponseEntity<Map<String, String>> saveEvent(@PathVariable String userName, @PathVariable Long id) {

        try {
            User userObject = service.listOneByName(userName);
            Event userEvent = new Event();
            userEvent.setId(id);
            Set<Event> set = new HashSet<Event>();
            set.addAll(userObject.getEvents());
            set.add(userEvent);
            userObject.setEvents(set);
            User userDB = service.storeEvent(userObject);
            Map<String, String> json = new HashMap<>();

            json.put("username", userDB.getUserName());
            json.put("message", "event add");
            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("prolem", e.getMessage());
            json.put("message", "Error to sign up");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }

    @GetMapping("/register")
    public List<User> listAll() {
        return service.listAll();
    }

    @GetMapping("/register/{id}")
    public User listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

}