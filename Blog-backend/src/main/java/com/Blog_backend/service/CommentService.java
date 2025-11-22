package com.Blog_backend.service;


import com.Blog_backend.payload.comment.CommentRequest;
import com.Blog_backend.payload.comment.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse create(Long postId , CommentRequest req , String userEmail);
    CommentResponse update(Long id , CommentRequest req , String userEmail);
    void delete(Long id , String userEmail);
    List<CommentResponse> getAll(Long postId);

}
