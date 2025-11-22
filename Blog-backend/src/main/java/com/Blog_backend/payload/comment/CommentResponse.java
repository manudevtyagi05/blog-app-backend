package com.Blog_backend.payload.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponse {
    public Long id;
    public String content;
    public Long postId;
    public Long userId;
    public String username;
    public LocalDateTime createdAt;
}
