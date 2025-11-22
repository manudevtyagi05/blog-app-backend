package com.Blog_backend.payload.post;

import com.Blog_backend.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {
    public String title;
    public String content;
    public Long categoryId;
    public List<String> tags;
    public String status;
}
