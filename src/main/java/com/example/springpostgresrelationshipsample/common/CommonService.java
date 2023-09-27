package com.example.springpostgresrelationshipsample.common;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.common.dto.AssignRoleToUserDTO;
import com.example.springpostgresrelationshipsample.common.dto.StudentLikeCourseDTO;
import com.example.springpostgresrelationshipsample.course.CourseRepository;
import com.example.springpostgresrelationshipsample.course.entity.Course;
import com.example.springpostgresrelationshipsample.role.RoleRepository;
import com.example.springpostgresrelationshipsample.role.entity.Role;
import com.example.springpostgresrelationshipsample.student.StudentRepository;
import com.example.springpostgresrelationshipsample.student.entity.Student;
import com.example.springpostgresrelationshipsample.user.UserRepository;
import com.example.springpostgresrelationshipsample.user.entity.User;

@Service
public class CommonService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<Object> assignRoleToUser(AssignRoleToUserDTO assignRoleToUserDTO) {
        Optional<User> optUser = userRepository.findById(assignRoleToUserDTO.getUserId());
        Optional<Role> optRole = roleRepository.findById(assignRoleToUserDTO.getRoleId());

        if (optRole.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        User user = optUser.get();
        Role role = optRole.get();
        user.setRole(role);
        User response = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Object> studentLikeCourse(StudentLikeCourseDTO studentLikeCourseDTO) {
        Optional<Student> optStudent = studentRepository.findById(studentLikeCourseDTO.getStudentId());
        Optional<Course> optCourse = courseRepository.findById(studentLikeCourseDTO.getCourseId());

        if (optStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        if (optCourse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }

        Student student = optStudent.get();
        Course course = optCourse.get();

        student.getLikedCourses().add(course);
        Student response = studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
