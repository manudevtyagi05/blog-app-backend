package com.Blog_backend.service;

import com.Blog_backend.payload.category.CategoryRequest;
import com.Blog_backend.payload.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryRequest req );
    CategoryResponse update(Long id , CategoryRequest req );
    void delete(Long id );
    CategoryResponse getByName(String name);
    CategoryResponse getById(Long id);
    List<CategoryResponse> getAll();
}
