package com.Blog_backend.service;


import com.Blog_backend.payload.tag.TagRequest;
import com.Blog_backend.payload.tag.TagResponse;


import java.util.List;

public interface TagService {
    TagResponse create(TagRequest req);
    TagResponse update(Long id , TagRequest req);
    void delect(Long id);
    TagResponse getById(Long id);
    TagResponse getByName(String name);
    List<TagResponse> getAll();
}
