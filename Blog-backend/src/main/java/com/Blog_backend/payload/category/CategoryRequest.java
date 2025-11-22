package com.Blog_backend.payload.category;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
    public String name;
}
