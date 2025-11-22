package com.Blog_backend.payload.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeResponse {
    public Long postId;
    public Long userId;
    public boolean liked;
    public long totalLikes;
}
