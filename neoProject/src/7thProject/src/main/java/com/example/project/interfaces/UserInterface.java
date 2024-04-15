package com.example.project.interfaces;

import com.example.project.dto.Request;
import org.springframework.http.ResponseEntity;

public interface UserInterface {
     ResponseEntity<String> authenticate(Request request) throws Exception;
     ResponseEntity<String> register(Request request)throws Exception;
}
