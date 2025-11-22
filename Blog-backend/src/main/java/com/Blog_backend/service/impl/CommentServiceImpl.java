package com.Blog_backend.service.impl;

import com.Blog_backend.model.Comment;
import com.Blog_backend.model.Post;
import com.Blog_backend.model.User;
import com.Blog_backend.payload.comment.CommentRequest;
import com.Blog_backend.payload.comment.CommentResponse;
import com.Blog_backend.repository.CommentRepository;
import com.Blog_backend.repository.PostRepository;
import com.Blog_backend.repository.UserRepository;
import com.Blog_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepo;
    private final PostRepository postRepo;
    private final CommentRepository commentRepo;

    @Override
    public CommentResponse create(Long postId ,CommentRequest req, String userEmail) {
        User user = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not Found"));

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not Found"));

        Comment comment = Comment.builder()
                .content(req.content)
                .post(post)
                .user(user)
                .build();

        commentRepo.save(comment);

        return toResponse(comment);
    }

    @Override
    public CommentResponse update(Long id, CommentRequest req, String userEmail) {
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not Found"));

        if(!comment.getUser().getEmail().equals(userEmail)) throw new RuntimeException("Not allowed");

        comment.setContent(req.getContent());

        commentRepo.save(comment);

        return toResponse(comment);

    }

    @Override
    public void delete(Long id, String userEmail) {

        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not Found"));

        if(!comment.getUser().getEmail().equals(userEmail)) throw new RuntimeException("Not allowed");

        commentRepo.delete(comment);
    }

    @Override
    public List<CommentResponse> getAll(Long postId) {
        return commentRepo.findByPostIdOrderByCreatedAtDesc(postId).stream()
                .map(this::toResponse)
                .toList();
    }


    CommentResponse toResponse(Comment comment) {
     return CommentResponse.builder()
             .id(comment.getId())
             .content(comment.getContent())
             .userId(comment.getUser().getId())
             .postId(comment.getPost().getId())
             .username(comment.getUser().getUsername())
             .createdAt(comment.getCreatedAt())
             .build();
    }
}
