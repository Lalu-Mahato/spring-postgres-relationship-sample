package com.example.springpostgresrelationshipsample.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springpostgresrelationshipsample.common.dto.AssignRoleToUserDTO;
import com.example.springpostgresrelationshipsample.common.dto.StudentLikeCourseDTO;

@RestController
@RequestMapping("/api/v1")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @PutMapping("/assign-role-to user")
    public ResponseEntity<Object> assignRoleToUser(@RequestBody AssignRoleToUserDTO assignRoleToUserDTO) {
        try {
            ResponseEntity<Object> response = commonService.assignRoleToUser(assignRoleToUserDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:" + e.getMessage());
        }
    }

    @PutMapping("/student-like-course")
    public ResponseEntity<Object> studentLikeCourse(@RequestBody StudentLikeCourseDTO studentLikeCourseDTO) {
        try {
            ResponseEntity<Object> response = commonService.studentLikeCourse(studentLikeCourseDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:" + e.getMessage());
        }
    }
}
