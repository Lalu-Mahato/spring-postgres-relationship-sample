package com.example.springpostgresrelationshipsample;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springpostgresrelationshipsample.user.UserRepository;
import com.example.springpostgresrelationshipsample.user.UserService;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository);
    }

    @Test
    void getAllUsers() {
        userService.findUsers();
        verify(userRepository).findAll();
    }

}
