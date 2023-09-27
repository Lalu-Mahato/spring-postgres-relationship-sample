package com.example.springpostgresrelationshipsample.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springpostgresrelationshipsample.user.dto.CreateUserDTO;
import com.example.springpostgresrelationshipsample.user.entity.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> findUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    public ResponseEntity<Object> addUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());

        User response = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
}
