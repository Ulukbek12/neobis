package com.example.week4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok().body("Hello  from api");
    }
    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayBye(){
        return ResponseEntity.ok().body("sayBye");
    }
}
