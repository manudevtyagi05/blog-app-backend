package com.Blog_backend.controller;

import com.Blog_backend.model.User;
import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.comment.CommentRequest;
import com.Blog_backend.payload.comment.CommentResponse;
import com.Blog_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post/{postId}")
    public ApiResponse<CommentResponse> create(@PathVariable Long postId , @RequestBody CommentRequest req , @AuthenticationPrincipal User user) {

        CommentResponse commentResponse = commentService.create(postId , req , user.getEmail());

        return ApiResponse.<CommentResponse>builder()
                .success(true)
                .data(commentResponse)
                .message("Comment Created Successfully")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<CommentResponse> update(@PathVariable Long id , @RequestBody CommentRequest req , @AuthenticationPrincipal User user) {

        CommentResponse commentResponse = commentService.update(id , req , user.getEmail());

        return ApiResponse.<CommentResponse>builder()
                .success(true)
                .data(commentResponse)
                .message("Comment Update Successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id , @AuthenticationPrincipal User user) {

        commentService.delete(id, user.getEmail());

        return ApiResponse.<Void>builder()
                .success(true)
                .data(null)
                .message("Comment deleted Successfully")
                .build();
    }

    @GetMapping("/post/{postId}")
    public ApiResponse<List<CommentResponse>> getAll(@PathVariable Long postId) {
        List<CommentResponse> commentResponse = commentService.getAll(postId);

        return ApiResponse.<List<CommentResponse>>builder()
                .success(true)
                .data(commentResponse)
                .message("Get All Comment in Desc Order Successfully")
                .build();
    }
}
