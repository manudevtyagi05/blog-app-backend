package com.Blog_backend.controller;


import com.Blog_backend.payload.ApiResponse;
import com.Blog_backend.payload.category.CategoryRequest;
import com.Blog_backend.payload.category.CategoryResponse;
import com.Blog_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ApiResponse<CategoryResponse> create(@RequestBody CategoryRequest req) {
        CategoryResponse categoryResponse = categoryService.create(req);
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .data(categoryResponse)
                .message("Category Created successfully")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponse> update(@PathVariable Long id , @RequestBody CategoryRequest req) {
        CategoryResponse categoryResponse = categoryService.update(id , req);
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .data(categoryResponse)
                .message("Category Updated successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .data(null)
                .message("Category deleted successfully")
                .build();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<CategoryResponse> getById(@PathVariable Long id) {
        CategoryResponse categoryResponse = categoryService.getById(id);
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .data(categoryResponse)
                .message("Get Category By id Successfully")
                .build();
    }

    @GetMapping("/name/{name}")
    public ApiResponse<CategoryResponse> getByName(@PathVariable String name) {
        CategoryResponse categoryResponse = categoryService.getByName(name);
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .data(categoryResponse)
                .message("Get Category By Name Successfully")
                .build();
    }

    @GetMapping()
    public ApiResponse<List<CategoryResponse>> getAll() {
        List<CategoryResponse> categoryResponse = categoryService.getAll();
        return ApiResponse.<List<CategoryResponse>>builder()
                .success(true)
                .data(categoryResponse)
                .message("Get All Category Successfully")
                .build();
    }

}
