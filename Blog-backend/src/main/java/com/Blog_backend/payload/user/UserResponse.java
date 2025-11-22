package com.Blog_backend.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    public Long id;
    public String username;
    public String email;
    public String bio;
    public String avatarUrl;
}
