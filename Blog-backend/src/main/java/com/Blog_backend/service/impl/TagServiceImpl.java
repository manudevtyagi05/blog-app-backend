package com.Blog_backend.service.impl;

import com.Blog_backend.model.Tag;
import com.Blog_backend.payload.tag.TagRequest;
import com.Blog_backend.payload.tag.TagResponse;
import com.Blog_backend.repository.TagRepository;
import com.Blog_backend.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepo;

    @Override
    public TagResponse create(TagRequest req) {
        if (tagRepo.findByName(req.getName()).isPresent()) {
            throw new RuntimeException("Tag already exists");
        }

        Tag tag = Tag.builder()
                .name(req.getName().toLowerCase())
                .build();

        tagRepo.save(tag);

        return tagResponse(tag);
    }

    @Override
    public TagResponse update(Long id, TagRequest req) {
        Tag tag = tagRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found"));

        tag.setName(req.getName().toLowerCase());

        tagRepo.save(tag);

        return tagResponse(tag);
    }

    @Override
    public void delect(Long id) {
        if (tagRepo.findById(id).isPresent()) {
            throw new RuntimeException("Tag Not Found");
        }

        tagRepo.deleteById(id);
    }

    @Override
    public TagResponse getById(Long id) {
        return tagResponse(tagRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found")));
    }

    @Override
    public TagResponse getByName(String name) {
        return tagResponse(tagRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Tag not found")));
    }

    @Override
    public List<TagResponse> getAll() {
        return tagRepo.findAll().stream()
                .map(this::tagResponse)
                .toList();
    }



    private TagResponse tagResponse(Tag tag) {
        return TagResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }

}
