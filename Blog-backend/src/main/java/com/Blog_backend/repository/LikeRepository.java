package com.Blog_backend.repository;

import com.Blog_backend.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id = :postId")
    long countLikesByPostId(Long postId);
    @Query("SELECT l FROM Like l WHERE l.post.id = :postId AND l.user.id = :userId")
    Optional<Like> findUserLike(Long postId, Long userId);
}
