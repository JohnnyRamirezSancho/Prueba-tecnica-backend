package com.pruebastecnicas.backend.controllers;

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

import com.pruebastecnicas.backend.models.Course;
import com.pruebastecnicas.backend.models.Role;
import com.pruebastecnicas.backend.models.User;
import com.pruebastecnicas.backend.services.UserService;

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

    @PostMapping(value = "/register/{iduser}/add/course/{idcourse}")
    public ResponseEntity<Map<String, String>> saveCourse(@PathVariable Long iduser, @PathVariable Long idcourse) {

        try {
            User userObject = service.listOne(iduser);
            Course userCourse = new Course();
            userCourse.setId(idcourse);
            Set<Course> set = new HashSet<Course>();
            set.addAll(userObject.getCourses());
            set.add(userCourse);
            userObject.setCourses(set);
            User userDB = service.storeCourse(userObject);
            Map<String, String> json = new HashMap<>();

            json.put("username", userDB.getUserName());
            json.put("message", "course add");
            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("problem", e.getMessage());
            json.put("message", "Error to add course");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }

    @GetMapping("/users")
    public List<User> listAll() {
        return service.listAll();
    }

    @GetMapping("/users/{id}")
    public User listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

}