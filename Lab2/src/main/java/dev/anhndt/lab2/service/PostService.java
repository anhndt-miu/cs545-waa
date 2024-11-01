package dev.anhndt.lab2.service;

import dev.anhndt.lab2.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto getPostById(long id);

    void createPost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id);

    List<PostDto> filterByAuthor(String author);

    List<PostDto> filterByAuthorContainsWord(String author);
}
