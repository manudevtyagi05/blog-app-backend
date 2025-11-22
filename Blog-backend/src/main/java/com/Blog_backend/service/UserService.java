package com.Blog_backend.service;

import com.Blog_backend.payload.user.UserRequest;
import com.Blog_backend.payload.user.UserResponse;

public interface UserService {
    UserResponse getProfile(Long id);
    UserResponse getUserByName(String name);
    UserResponse updateProfile(Long id , UserRequest req , Long userId);
    void deleteProfile(Long id , Long userId);
}
