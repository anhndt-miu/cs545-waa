package dev.anhndt.lab1.repository.impl;

import dev.anhndt.lab1.entity.Post;
import dev.anhndt.lab1.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PostRepositoryImpl implements PostRepository {
    private static final List<Post> posts;

    static {
        posts = new ArrayList<>();

        posts.add(new Post(1, "Java Basics", "Learn the basics of Java, including syntax, variables, and data types.", "Alice"));
        posts.add(new Post(2, "Advanced Java", "Deep dive into advanced Java concepts like Streams and Lambdas.", "Bob"));
        posts.add(new Post(3, "Java in Web Development", "Explore how Java is used in web development and frameworks like Spring.", "Carol"));
        posts.add(new Post(4, "Java and Databases", "Learn about connecting Java with databases using JDBC and Hibernate.", "Dave"));
        posts.add(new Post(5, "Java Design Patterns", "A comprehensive guide to design patterns in Java.", "Eve"));
        posts.add(new Post(6, "Testing in Java", "Understand different testing frameworks and techniques in Java.", "Frank"));
        posts.add(new Post(7, "Java Performance Tuning", "Tips and techniques for optimizing Java applications.", "Grace"));
        posts.add(new Post(8, "Java and Multithreading", "Explore multithreading in Java and its practical applications.", "Hank"));
        posts.add(new Post(9, "Introduction to JavaFX", "Learn about building GUI applications in Java with JavaFX.", "Ivy"));
        posts.add(new Post(10, "Java Security Essentials", "A look into Java's security features and practices.", "John"));
    }

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPostById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void createPost(Post post) {
        Post checkingPost = getPostById(post.getId());
        if (checkingPost != null) {
            return;
        }

        posts.add(post);
    }

    @Override
    public void updatePost(long id, Post post) {
        posts.stream().filter(x -> x.getId() == id).findFirst().ifPresent(item -> {
            item.setTitle(post.getTitle());
            item.setContent(post.getContent());
            item.setAuthor(post.getAuthor());
        });
    }

    @Override
    public void deletePost(long id) {
        posts.stream().filter(x -> x.getId() == id).findFirst().ifPresent(posts::remove);
    }

    @Override
    public List<Post> filterByAuthor(String author) {
        return posts.stream().filter(x -> x.getAuthor().contentEquals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Post> filterByAuthorContainWord(String author) {
        return posts.stream().filter(x -> x.getAuthor().toLowerCase().contains(author.toLowerCase())).collect(Collectors.toList());
    }

}
