package com.example.springpostgresrelationshipsample.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springpostgresrelationshipsample.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
