package com.Blog_backend.service.impl;

import com.Blog_backend.model.Like;
import com.Blog_backend.model.Post;
import com.Blog_backend.model.User;
import com.Blog_backend.repository.LikeRepository;
import com.Blog_backend.repository.PostRepository;
import com.Blog_backend.repository.UserRepository;
import com.Blog_backend.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepo;
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Override
    public boolean toggleLike(Long postId, Long userId) {

        Optional<Like> existing = likeRepo.findUserLike(postId, userId);

        if (existing.isPresent()) {
            likeRepo.delete(existing.get());
            return false; // unliked
        }

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Like like = Like.builder()
                .post(post)
                .user(user)
                .build();

        likeRepo.save(like);
        return true; // liked
    }

    @Override
    public long countLikes(Long postId) {
        return likeRepo.countLikesByPostId(postId);
    }
}
