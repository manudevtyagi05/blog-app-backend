package com.Blog_backend.service.impl;

import com.Blog_backend.model.User;
import com.Blog_backend.payload.user.UserRequest;
import com.Blog_backend.payload.user.UserResponse;
import com.Blog_backend.repository.UserRepository;
import com.Blog_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public UserResponse getProfile(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user Not Found"));
        return toResponse(user);
    }

    @Override
    public UserResponse getUserByName(String name) {
        User user = userRepo.findByUsername(name)
                .orElseThrow(() -> new RuntimeException("user Not Found"));
        return toResponse(user);
    }

    @Override
    public UserResponse updateProfile(Long id, UserRequest req , Long userId) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user Not Found"));

        if(!user.getId().equals(userId)) throw new RuntimeException("Not allowed");

        user.setBio(req.bio);
        user.setAvatarUrl(req.avatarUrl);

        userRepo.save(user);

        return toResponse(user);
    }

    @Override
    public void deleteProfile(Long id, Long userId) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user Not Found"));

        if(!user.getId().equals(userId)) throw new RuntimeException("Not allowed");

        userRepo.delete(user);
    }


    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(user.getBio())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}
