package com.blogapp.service;

import com.blogapp.payload.CommentDto;

public interface CommentService {

    // Add comment to post
    CommentDto createComment(CommentDto commentDto, Integer postId);

    // Delete comment by ID
    void deleteComment(Integer commentId);
}
