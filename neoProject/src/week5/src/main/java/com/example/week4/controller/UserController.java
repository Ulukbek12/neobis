package com.example.week4.controller;

import com.example.week4.dto.Request;
import com.example.week4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> authenticate(@RequestBody Request request){
        return userService.authenticate(request);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Request request) {
        return userService.registerUser(request);
    }
}
