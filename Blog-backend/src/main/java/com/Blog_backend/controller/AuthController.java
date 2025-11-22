package com.Blog_backend.controller;

import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.auth.AuthResponse;
import com.Blog_backend.payload.auth.LoginRequest;
import com.Blog_backend.payload.auth.RegisterRequest;
import com.Blog_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@RequestBody RegisterRequest req) {
        AuthResponse authResponse = authService.register(req);
        return ApiResponse.<AuthResponse>builder()
                .success(true)
                .data(authResponse)
                .message("User registered successfully")
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest req) {
        AuthResponse authResponse = authService.login(req);
        return ApiResponse.<AuthResponse>builder()
                .success(true)
                .data(authResponse)
                .message("User login successfully")
                .build();
    }
}
