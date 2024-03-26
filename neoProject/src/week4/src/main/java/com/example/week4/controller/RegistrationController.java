package com.example.week4.controller;

import com.example.week4.dto.UserDto;
import com.example.week4.entity.Role;
import com.example.week4.entity.User;
import com.example.week4.repository.RoleRepository;
import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username has already exists");
        }
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");

        if (userRole == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Role 'ROLE_USER' not found");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Username registered successfully");
    }
}
