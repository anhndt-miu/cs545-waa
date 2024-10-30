package dev.anhndt.lab1.service;

import dev.anhndt.lab1.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    void createPost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id);

    List<PostDto> filterByAuthor(String author);

    List<PostDto> filterByAuthorContainsWord(String author);
}
