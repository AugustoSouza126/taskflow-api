package com.augusto.taskflow.controller;

import com.augusto.taskflow.dto.LoginRequestDTO;
import com.augusto.taskflow.dto.LoginResponseDTO;
import com.augusto.taskflow.dto.RegisterRequestDTO;
import com.augusto.taskflow.dto.UserResponseDTO;
import com.augusto.taskflow.model.User;
import com.augusto.taskflow.service.AuthService;
import com.augusto.taskflow.service.JwtService;
import org.springframework.web.bind.annotation.*;
import com.augusto.taskflow.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthService service;

    public AuthController(
            AuthService service,
            JwtService jwtService,
            UserRepository userRepository) {

        this.service = service;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
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

    // Retorna dados do usuário logado
    @GetMapping("/me")
    public UserResponseDTO me(
            @RequestHeader("Authorization") String authHeader) {

        // Remove "Bearer " do início do token
        String token =
                authHeader.replace("Bearer ", "");

        // Extrai email do JWT
        String email =
                jwtService.extractEmail(token);

        // Busca usuário pelo email
        User user =
                userRepository.findByEmail(email)
                        .orElseThrow();

        // Monta DTO de resposta
        UserResponseDTO dto =
                new UserResponseDTO();

        dto.setId(user.getId());

        dto.setName(user.getName());

        dto.setEmail(user.getEmail());

        return dto;
    }
}