package com.Blog_backend.service.impl;

import com.Blog_backend.exception.BadRequestException;
import com.Blog_backend.model.User;
import com.Blog_backend.payload.auth.AuthResponse;
import com.Blog_backend.payload.auth.LoginRequest;
import com.Blog_backend.payload.auth.RegisterRequest;
import com.Blog_backend.payload.user.UserRequest;
import com.Blog_backend.payload.user.UserResponse;
import com.Blog_backend.repository.UserRepository;
import com.Blog_backend.security.JwtUtil;
import com.Blog_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthResponse register(RegisterRequest req) {
        if ( userRepo.existsByUsername(req.username)  || userRepo.existsByEmail(req.email)) throw new BadRequestException("UserName Or Email is Used");
        User user = User.builder()
                .username(req.username)
                .email(req.email)
                .password(passwordEncoder.encode(req.password))
                .build();
        userRepo.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token , 36600L);
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(req.password , user.getPassword())) throw new BadRequestException("Invalid credentials");
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token , 3600L);
    }



}
