package com.pruebastecnicas.backend.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long id;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "courses")
    List<User> users;

    @OneToMany
    @JoinColumn(name = "id_course")
    private List<ShoppingCartItem> shoppingCartItem;

    public Course() {
    }

    public Course(Long id, String course, String description) {
        this.id = id;
        this.course = course;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}