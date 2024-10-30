package dev.anhndt.lab1.repository;

import dev.anhndt.lab1.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();

    Post getPostById(long id);

    void createPost(Post post);

    void updatePost(long id, Post post);

    void deletePost(long id);
}
