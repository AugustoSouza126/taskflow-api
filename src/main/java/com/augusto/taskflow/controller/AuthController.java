package com.augusto.taskflow.controller;

import com.augusto.taskflow.dto.LoginRequestDTO;
import com.augusto.taskflow.dto.LoginResponseDTO;
import com.augusto.taskflow.dto.RegisterRequestDTO;
import com.augusto.taskflow.model.User;
import com.augusto.taskflow.service.AuthService;
import com.augusto.taskflow.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthService service;

    public AuthController(
            AuthService service,
            JwtService jwtService) {

        this.service = service;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequestDTO dto) {

        return service.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginRequestDTO dto) {

        return service.login(dto);
    }

    @GetMapping("/test")
    public String testToken(
            @RequestParam String token) {

        return jwtService.extractEmail(token);
    }
}