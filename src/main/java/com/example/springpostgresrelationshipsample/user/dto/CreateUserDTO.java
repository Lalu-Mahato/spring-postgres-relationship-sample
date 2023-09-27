package com.example.springpostgresrelationshipsample.user.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String name;
    private String email;
}
