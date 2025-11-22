package com.Blog_backend.payload.category;

import com.Blog_backend.payload.post.PostResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    public Long id;
    public String name;
    public List<PostResponse> posts;
}
