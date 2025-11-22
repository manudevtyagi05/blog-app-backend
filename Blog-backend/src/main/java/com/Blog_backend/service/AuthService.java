package com.Blog_backend.service;

import com.Blog_backend.payload.auth.AuthResponse;
import com.Blog_backend.payload.auth.LoginRequest;
import com.Blog_backend.payload.auth.RegisterRequest;
import com.Blog_backend.payload.user.UserRequest;
import com.Blog_backend.payload.user.UserResponse;

import java.util.List;

public interface AuthService {
    AuthResponse register(RegisterRequest req);
    AuthResponse login(LoginRequest req);
}
