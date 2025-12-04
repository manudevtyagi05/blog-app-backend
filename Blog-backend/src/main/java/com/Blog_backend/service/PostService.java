package com.Blog_backend.service;


import com.Blog_backend.payload.post.PostRequest;
import com.Blog_backend.payload.post.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostResponse create(PostRequest req , String authorEmail);
    PostResponse update(Long id , PostRequest req , String authorEmail);
    void delete(Long id , String authEmail);
    PostResponse publish(Long id , String authorEmail);
    PostResponse getPost(Long id);
    Page<PostResponse> getAll(Pageable pageable);
    Page<PostResponse> getByAuthorId(Long authorId, Pageable pageable);
    Page<PostResponse> getAllPublish(Pageable pageable);
    List<PostResponse> searchPosts(String keyword);
}
