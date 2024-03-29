package com.example.week4.service;

import com.example.week4.dto.UserDto;
import com.example.week4.entity.User;
import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public ResponseEntity<String> registerUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username has already exists");
        }

        String userRole = userRepository.findByRole("user");
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                userRole);

        if (userRole == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Role 'user' not found");
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Username registered successfully");
    }
}
