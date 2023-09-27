package com.example.springpostgresrelationshipsample.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.course.dto.CreateCourseDTO;
import com.example.springpostgresrelationshipsample.course.entity.Course;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<Object> findCourses() {
        List<Course> courses = courseRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    public ResponseEntity<Object> addCourse(CreateCourseDTO createCourseDTO) {
        Course course = new Course();
        course.setName(createCourseDTO.getName());

        Course response = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
