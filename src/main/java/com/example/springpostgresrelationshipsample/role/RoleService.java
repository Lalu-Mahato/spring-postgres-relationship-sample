package com.example.springpostgresrelationshipsample.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.role.dto.CreateRoleDTO;
import com.example.springpostgresrelationshipsample.role.entity.Role;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<Object> findAll() {
        List<Role> roles = roleRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }

    public ResponseEntity<Object> create(CreateRoleDTO createRoleDTO) {
        Role role = new Role();
        role.setName(createRoleDTO.getName());
        role.setDescription(createRoleDTO.getDescription());
        Role response = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
