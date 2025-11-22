package com.Blog_backend.controller;

import com.Blog_backend.model.User;
import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.user.UserRequest;
import com.Blog_backend.payload.user.UserResponse;
import com.Blog_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PutMapping("/{id}")
    public ApiResponse<UserResponse> update(@PathVariable Long id , @RequestBody UserRequest req , @AuthenticationPrincipal User user) {

        UserResponse userResponse = userService.updateProfile(id, req ,user.getId());

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .data(userResponse)
                .message("Profile Update Successfully")
                .build();
    }


    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id , @AuthenticationPrincipal User user) {

         userService.deleteProfile(id, user.getId());

        return ApiResponse.<Void>builder()
                .success(true)
                .data(null)
                .message("Profile Update Successfully")
                .build();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<UserResponse> getById(@PathVariable Long id) {

        UserResponse userResponse = userService.getProfile(id);
        return ApiResponse.<UserResponse>builder()
                .success(true)
                .data(userResponse)
                .message("Get Profile By ID Successfully")
                .build();
    }

    @GetMapping("/name/{name}")
    public ApiResponse<UserResponse> getByName(@PathVariable String name) {

        UserResponse userResponse = userService.getUserByName(name);
        return ApiResponse.<UserResponse>builder()
                .success(true)
                .data(userResponse)
                .message("Get Profile By Name Successfully")
                .build();
    }

}
