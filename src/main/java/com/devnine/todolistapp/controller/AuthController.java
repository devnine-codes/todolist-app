package com.devnine.todolistapp.controller;

import com.devnine.todolistapp.model.User;
import com.devnine.todolistapp.service.UserService;
import com.devnine.todolistapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest) {
        User user = userService.getUserByEmail(loginRequest.getEmail());
        if (user.getPassword().equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    @PostMapping("/logout")
    public Map<String, String> logout(@RequestHeader("Authorization") String token) {
        jwtUtil.invalidateToken(token.substring(7)); // "Bearer " 부분 제거
        Map<String, String> response = new HashMap<>();
        response.put("message", "Successfully logged out");
        return response;
    }

}
