package com.example.week5.service;


import com.example.week5.config.JwtUtils;
import com.example.week5.dto.Request;
import com.example.week5.entity.Role;
import com.example.week5.entity.User;
import com.example.week5.exception.UserExists;
import com.example.week5.exception.UserNotFound;
import com.example.week5.interfaces.UserServices;
import com.example.week5.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService implements UserServices {
     UserRepository userRepository;
     PasswordEncoder passwordEncoder;
     AuthenticationManager authenticationManager;
     JwtUtils jwtUtils;
     @Override
    public ResponseEntity<String> registerUser(Request request)throws UserExists {
        if(userRepository.findByEmail(request.getEmail()) != null){
            throw new UserExists("User with email " + request.getEmail() + " already exist.");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
    }
    @Override
    public ResponseEntity<String> authenticate(Request request)throws UserNotFound {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        final UserDetails userDetails = userRepository.findByEmail(request.getEmail());
        if(userDetails != null){
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        }else{
            throw new UserNotFound("User not found");
        }
    }
}


