package com.pruebastecnicas.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pruebastecnicas.backend.models.Course;
import com.pruebastecnicas.backend.services.CourseService;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    private CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Course> listAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course listOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Course newcourse) {

        try {
            return ResponseEntity.ok(service.save(newcourse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("error");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Course course){
        try {
            Course courseToUpdate = service.getOne(id);
            if(courseToUpdate != null){
                course.setId(id);;
                service.save(course);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}