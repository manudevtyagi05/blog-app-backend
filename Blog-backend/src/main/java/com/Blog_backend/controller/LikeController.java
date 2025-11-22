package com.Blog_backend.controller;

import com.Blog_backend.model.User;
import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.like.LikeResponse;
import com.Blog_backend.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/post/{postId}")
    public ApiResponse<Boolean> toggle(@PathVariable Long postId, @AuthenticationPrincipal User user) {

        Boolean liked = likeService.toggleLike(postId, user.getId());

        return ApiResponse.<Boolean>builder()
                .success(true)
                .data(liked)
                .message(liked ? "Post liked" : "Post unliked")
                .build();
    }

    @GetMapping("/post/{postId}")
    public ApiResponse<Long> count(@PathVariable Long postId) {
        return ApiResponse.<Long>builder()
                .success(true)
                .data(likeService.countLikes(postId))
                .message("Get all Likes")
                .build();
    }
}

