package com.Blog_backend.controller;

import com.Blog_backend.model.User;
import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.post.PostRequest;
import com.Blog_backend.payload.post.PostResponse;
import com.Blog_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping
    public ApiResponse<PostResponse> create(@RequestBody PostRequest req , @AuthenticationPrincipal User user) {
        PostResponse postResponse = postService.create(req , user.getEmail());

        return ApiResponse.<PostResponse>builder()
                .success(true)
                .data(postResponse)
                .message("Post Created successfully")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PostResponse> update(@PathVariable Long id , @RequestBody PostRequest req , @AuthenticationPrincipal User user){
        PostResponse postResponse = postService.update(id , req , user.getEmail());

        return ApiResponse.<PostResponse>builder()
                .success(true)
                .data(postResponse)
                .message("Post Updated successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id , @AuthenticationPrincipal User user) {
        postService.delete(id , user.getEmail());

        return ApiResponse.<Void>builder()
                .success(true)
                .data(null)
                .message("Post Deleted successfully")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PostResponse> getById(@PathVariable Long id) {
        PostResponse postResponse = postService.getPost(id);

        return ApiResponse.<PostResponse>builder()
                .success(true)
                .data(postResponse)
                .message("Get Post By ID successfully")
                .build();
    }

    @PutMapping("/{id}/publish")
    public ApiResponse<PostResponse> publish(@PathVariable Long id , @AuthenticationPrincipal User user) {
        PostResponse postResponse = postService.publish(id ,user.getEmail());

        return ApiResponse.<PostResponse>builder()
                .success(true)
                .data(postResponse)
                .message("Post Publish successfully")
                .build();
    }

    @GetMapping("/publish")
    public ApiResponse<Page<PostResponse>> getALlPublish(Pageable pageable) {
        Page<PostResponse> postResponse = postService.getAllPublish(pageable);

        return ApiResponse.<Page<PostResponse>>builder()
                .success(true)
                .data(postResponse)
                .message("Post Publish successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<Page<PostResponse>> getAll(Pageable pageable) {
        Page<PostResponse> postResponse =  postService.getAll(pageable);

        return ApiResponse.<Page<PostResponse>>builder()
                .success(true)
                .data(postResponse)
                .message("Get All Posts successfully")
                .build();
    }

    @GetMapping("/author/{authorId}")
    public ApiResponse<Page<PostResponse>> getByAuthorId(@PathVariable Long authorId , Pageable pageable){

        Page<PostResponse> postResponse =  postService.getByAuthorId(authorId, pageable);

        return ApiResponse.<Page<PostResponse>>builder()
                .success(true)
                .data(postResponse)
                .message("Get All Posts By AuthorID successfully")
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<PostResponse>> searchPosts(@RequestParam String keyword) {
        List<PostResponse> postResponses = postService.searchPosts(keyword);

        return ApiResponse.<List<PostResponse>>builder()
                .success(true)
                .data(postResponses)
                .message("Get All searched posts")
                .build();
    }
}
