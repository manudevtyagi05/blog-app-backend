package com.Blog_backend.service;


public interface LikeService {
    boolean toggleLike(Long postId, Long userId);
    long countLikes(Long postId);
}

