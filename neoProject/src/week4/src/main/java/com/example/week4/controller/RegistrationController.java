package com.example.week4.controller;

import com.example.week4.dto.UserDto;
import com.example.week4.entity.User;
import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
    if(userRepository.findByUsername(userDto.getUsername()) != null){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username has already exists");
    }

    User user = new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("Username registered successfully");
    }
}
