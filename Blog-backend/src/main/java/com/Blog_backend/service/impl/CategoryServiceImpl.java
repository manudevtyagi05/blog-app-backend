package com.Blog_backend.service.impl;


import com.Blog_backend.model.Category;
import com.Blog_backend.model.Tag;
import com.Blog_backend.payload.category.CategoryRequest;
import com.Blog_backend.payload.category.CategoryResponse;
import com.Blog_backend.payload.comment.CommentResponse;
import com.Blog_backend.payload.post.PostResponse;
import com.Blog_backend.repository.CategoryRepository;
import com.Blog_backend.repository.LikeRepository;
import com.Blog_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final LikeRepository likeRepo;


    @Override
    public CategoryResponse create(CategoryRequest req) {

        Category category = Category.builder()
                .name(req.getName())
                .build();

        return toResponse(category);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest req) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new  RuntimeException("Category not Found"));

        category.setName(req.getName());

        categoryRepo.save(category);

        return toResponse(category);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new  RuntimeException("Category not Found"));
        categoryRepo.delete(category);
    }

    @Override
    public CategoryResponse getByName(String name) {
     Category category = categoryRepo.findByName(name)
             .orElseThrow(() -> new RuntimeException("Category not Found"));

        return toResponse(category);
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category =  categoryRepo.findById(id)
                .orElseThrow(() -> new  RuntimeException("Category not Found"));

        return toResponse(category);
    }

    @Override
    public List<CategoryResponse> getAll() {
       return categoryRepo.findAll()
               .stream()
               .map(this::toResponse)
               .toList();

    }

    private CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .posts(category.getPosts() != null
                        ? category.getPosts().stream()
                        .map(post -> PostResponse.builder()
                                .title(post.getTitle())
                                .slug(post.getSlug())
                                .content(post.getContent())
                                .coverImage(post.getCoverImage())
                                .author(post.getAuthor() != null ? post.getAuthor().getUsername() : null)
                                .status(post.getStatus() != null ? post.getStatus().name() : null)
                                .tags(post.getTags() != null ? post.getTags().stream().map(Tag::getName).toList() : Collections.emptyList())
                                .category(post.getCategory() != null ? post.getCategory().getName() : null)
                                .comments(post.getComments() !=null
                                        ? post.getComments().stream()
                                        .map(comment -> CommentResponse.builder()
                                                .username(comment.getUser().getUsername())
                                                .content(comment.getContent())
                                                .createdAt(comment.getCreatedAt())
                                                .build())
                                                .toList()
                                        : Collections.emptyList())
                                .views(post.getViews())
                                .likes(likeRepo.countLikesByPostId(post.getId()))
                                .createdAt(post.getCreatedAt())
                                .updatedAt(post.getUpdatedAt())
                                .build())
                        .toList()
                        : Collections.emptyList()
                )
                .build();
    }


}
