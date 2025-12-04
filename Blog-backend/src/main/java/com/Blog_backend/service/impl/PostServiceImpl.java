package com.Blog_backend.service.impl;



import com.Blog_backend.model.*;
import com.Blog_backend.payload.comment.CommentResponse;
import com.Blog_backend.payload.post.PostRequest;
import com.Blog_backend.payload.post.PostResponse;
import com.Blog_backend.repository.*;
import com.Blog_backend.service.PostService;
import com.Blog_backend.utils.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;
    private final PostRepository postRepo;
    private final TagRepository tagRepo;
    private final LikeRepository likeRepo;

    @Override
    public PostResponse create(PostRequest req,  String authorEmail) {
        User author = userRepo.findByEmail(authorEmail)
                .orElseThrow(() -> new RuntimeException("User not Found"));


        Category category = categoryRepo.findById(req.categoryId)
                .orElseThrow(() -> new RuntimeException("Category not Found"));


        List<Tag> tags = processTags(req.getTags());




        Post post = Post.builder()
                .title(req.title)
                .slug(SlugUtil.toSlug(req.title))
                .content(req.content)
                .coverImage(req.coverImage)
                .status(PostStatus.valueOf(req.status))
                .author(author)
                .category(category)
                .tags(tags)
                .createdAt(LocalDateTime.now())
                .build();

        postRepo.save(post);


        return toResponse(post);
    }

    @Override
    public PostResponse update(Long id, PostRequest req,  String authorEmail) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        if(!post.getAuthor().getEmail().equals(authorEmail)) throw new RuntimeException("Not allowed");

        List<Tag> tags = processTags(req.getTags());

        post.setTitle(req.title);
        post.setSlug(SlugUtil.toSlug(req.title));
        post.setContent(req.content);
        post.setCoverImage(req.coverImage);
        post.setStatus(PostStatus.valueOf(req.status));
        post.setUpdatedAt(LocalDateTime.now());
        if (req.categoryId!= null) post.setCategory(categoryRepo.findById(req.categoryId).orElseThrow());
        if (req.tags != null) post.setTags(tags);


        postRepo.save(post);

        return toResponse(post);
    }

    @Override
    public void delete(Long id,  String authorEmail) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        if(!post.getAuthor().getEmail().equals(authorEmail)) throw new RuntimeException("Not allowed");

        postRepo.delete(post);
    }

    @Override
    public PostResponse publish(Long id, String authorEmail) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        if(!post.getAuthor().getEmail().equals(authorEmail)) throw new RuntimeException("Not allowed");

        post.setStatus(PostStatus.PUBLISHED);
        post.setUpdatedAt(LocalDateTime.now());

        postRepo.save(post);

        return toResponse(post);
    }


    @Override
    public PostResponse getPost(Long id) {

        return toResponse(postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"))
        );
    }

    @Override
    public Page<PostResponse> getAll(Pageable pageable) {
        return postRepo.findAll(pageable)
                .map(this::toResponse);
    }

    @Override
    public Page<PostResponse> getByAuthorId(Long authorId, Pageable pageable) {
        User user = userRepo.findById(authorId)
                .orElseThrow(() ->new RuntimeException("User not found"));
        return postRepo.findAllByAuthorId(authorId ,pageable).map(this::toResponse);
    }

    @Override
    public Page<PostResponse> getAllPublish(Pageable pageable) {
        return postRepo.findPublished(pageable).map(this::toResponse);
    }

    @Override
    public List<PostResponse> searchPosts(String keyword) {
       List<Post> posts = postRepo.searchPosts(keyword);

       return posts.stream()
               .map(this::toResponse)
               .toList();
    }


    private List<Tag> processTags(List<String> tags) {
        List<Tag> tagList = new ArrayList<>();

        for (String name : tags) {

            String cleanName = name.trim().toLowerCase();

             Tag tag = tagRepo.findByName(cleanName)
                    .orElseGet(() -> tagRepo.save(
                            Tag.builder()
                                    .name(cleanName)
                                    .build()
                    ));

             tagList.add(tag);
        }
        return tagList;
    }



    private PostResponse toResponse(Post post) {

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .slug(post.getSlug())
                .content(post.getContent())
                .coverImage(post.getCoverImage())
                .author(post.getAuthor() != null ? post.getAuthor().getUsername() : null)
                .status(post.getStatus() != null ? post.getStatus().name() : null)
                .tags(post.getTags() != null ? post.getTags().stream().map(Tag::getName).toList() : Collections.emptyList())
                .category(post.getCategory() != null ? post.getCategory().getName() : null)
                .comments(post.getComments() !=null
                        ? post.getComments().stream()
                        .map(comment -> CommentResponse.builder()
                                .id(comment.getId())
                                .username(comment.getUser().getUsername())
                                .userId(comment.getUser().getId())
                                .postId(comment.getPost().getId())
                                .content(comment.getContent())
                                .createdAt(comment.getCreatedAt())
                                .build())
                        .toList()
                        : Collections.emptyList())
                .views(post.getViews())
                .likes(likeRepo.countLikesByPostId(post.getId()))
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }




}
