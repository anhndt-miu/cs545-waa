package dev.anhndt.lab5.service;

import dev.anhndt.lab5.entity.dto.CommentDto;
import dev.anhndt.lab5.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto getPostById(long id);

    void createPost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id);

    List<PostDto> filterByAuthor(String author);

    List<PostDto> filterByAuthorContainsWord(String author);

    List<PostDto> findPostsByTitle(String title);

    List<PostDto> findPostsByAuthor(String author);

    CommentDto addComment(long postId, CommentDto comment);
}
