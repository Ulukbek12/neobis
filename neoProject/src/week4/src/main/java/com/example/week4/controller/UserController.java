package com.example.week4.controller;

import com.example.week4.entity.User;
import com.example.week4.dto.AuthenticationRequest;
import com.example.week4.exception.UserExists;
import com.example.week4.repository.UserRepository;
import com.example.week4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
        return userService.authenticate(request);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthenticationRequest request) {
        return userService.registerUser(request);
    }
}
