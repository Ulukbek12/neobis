package com.example.project.сontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Demo {
    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok().body("Home...");
    }
}
