package com.example.springpostgresrelationshipsample.common;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.common.dto.AssignRoleToUserDTO;
import com.example.springpostgresrelationshipsample.role.RoleRepository;
import com.example.springpostgresrelationshipsample.role.entity.Role;
import com.example.springpostgresrelationshipsample.user.UserRepository;
import com.example.springpostgresrelationshipsample.user.entity.User;

@Service
public class CommonService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

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
}
