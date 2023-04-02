package com.pruebastecnicas.backend.services;

import org.springframework.stereotype.Service;

import com.pruebastecnicas.backend.models.Course;
import com.pruebastecnicas.backend.repositories.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getOne(Long id) {
        Course course = repository.findById(id).orElse(null);
        return course;
    }

    public Course getOneByRole(String course) {
        Course courseFind = repository.findByCourse(course).orElse(null);
        return courseFind;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Course save(Course course) {
        Course newCourse=repository.save(course);
        return newCourse;
    }
}
