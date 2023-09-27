package com.example.springpostgresrelationshipsample.student.entity;

import java.util.List;

import com.example.springpostgresrelationshipsample.course.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonIgnoreProperties(value = "likes")
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id"),
    })
    private List<Course> likedCourses;
}
