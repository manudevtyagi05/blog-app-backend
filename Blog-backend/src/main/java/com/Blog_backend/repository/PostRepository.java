package com.Blog_backend.repository;

import com.Blog_backend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.status = 'PUBLISHED'")
    Page<Post> findPublished(Pageable pageable);
    Page<Post> findAllByAuthorId(Long authorId, Pageable pageable);
    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.name = :tag")
    Page<Post> findByTagName(String tag, Pageable pageable);
    List<Post> findByCategoryId(Long categoryId);
    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR p.content LIKE CONCAT('%', :keyword, '%')")
    List<Post> searchPosts(String keyword);
}
