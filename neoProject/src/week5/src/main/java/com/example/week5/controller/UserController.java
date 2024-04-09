package com.example.week5.controller;

import com.example.week5.dto.Request;
import com.example.week5.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
     UserService userService;
    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestBody Request request){
        return userService.authenticate(request);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Request request) {
        return userService.registerUser(request);
    }
}
