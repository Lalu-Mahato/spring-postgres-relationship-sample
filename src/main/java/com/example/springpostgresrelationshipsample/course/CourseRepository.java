package com.example.springpostgresrelationshipsample.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springpostgresrelationshipsample.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
