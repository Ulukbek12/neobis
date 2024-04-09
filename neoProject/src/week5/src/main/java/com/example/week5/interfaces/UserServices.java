package com.example.week5.interfaces;

import com.example.week5.dto.Request;
import org.springframework.http.ResponseEntity;

public interface UserServices {
     ResponseEntity<String> registerUser(Request request);
     ResponseEntity<String> authenticate(Request request);
}
