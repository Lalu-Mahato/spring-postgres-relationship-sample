package com.example.springpostgresrelationshipsample.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.student.dto.CreateStudentDTO;
import com.example.springpostgresrelationshipsample.student.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Object> findStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    public ResponseEntity<Object> addStudent(CreateStudentDTO createStudentDTO) {
        Student student = new Student();
        student.setName(createStudentDTO.getName());

        Student response = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
