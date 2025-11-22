package com.Blog_backend.payload.post;

import com.Blog_backend.model.Category;
import com.Blog_backend.model.Comment;
import com.Blog_backend.model.Tag;
import com.Blog_backend.payload.comment.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    public Long id;
    public String title;
    public String slug;
    public String content;
    public String coverImage;
    public String author;
    public String status;
    public List<String> tags;
    public String category;
    public List<CommentResponse> comments;
    public Long views;
    public Long likes;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
