package com.Blog_backend.controller;


import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.tag.TagRequest;
import com.Blog_backend.payload.tag.TagResponse;
import com.Blog_backend.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ApiResponse<TagResponse> create(@RequestBody TagRequest req) {
        TagResponse tagResponse = tagService.create(req);

        return ApiResponse.<TagResponse>builder()
                .success(true)
                .data(tagResponse)
                .message("Tag Created Successfully")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<TagResponse> update(@PathVariable Long id ,@RequestBody TagRequest req) {
        TagResponse tagResponse = tagService.update(id ,req);

        return ApiResponse.<TagResponse>builder()
                .success(true)
                .data(tagResponse)
                .message("Tag Updated Successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        tagService.delect(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .data(null)
                .message("Tag Deleted Successfully")
                .build();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<TagResponse> getByID(@PathVariable Long id) {
        TagResponse tagResponse = tagService.getById(id);

        return ApiResponse.<TagResponse>builder()
                .success(true)
                .data(tagResponse)
                .message("Get Tag By ID Successfully")
                .build();
    }

    @GetMapping("/name/{name}")
    public ApiResponse<TagResponse> getByID(@PathVariable String name) {
        TagResponse tagResponse = tagService.getByName(name);

        return ApiResponse.<TagResponse>builder()
                .success(true)
                .data(tagResponse)
                .message("Get Tag By Name Successfully")
                .build();
    }

    @GetMapping()
    public ApiResponse<List<TagResponse>> getByID() {
        List<TagResponse> tagResponse = tagService.getAll();

        return ApiResponse.<List<TagResponse>>builder()
                .success(true)
                .data(tagResponse)
                .message("Get All Tag Successfully")
                .build();
    }
}
