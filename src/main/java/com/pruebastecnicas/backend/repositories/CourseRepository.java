package com.pruebastecnicas.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebastecnicas.backend.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

    public Optional<Course> findByCourse(String course);
   
}