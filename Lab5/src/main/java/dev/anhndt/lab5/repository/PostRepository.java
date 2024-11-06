package dev.anhndt.lab5.repository;

import dev.anhndt.lab5.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("Select p from Post p where p.title=:title")
    List<Post> findByTitle(@Param("title") String title);

    @Query("Select p from Post p where p.author=:author")
    List<Post> findByAuthor(@Param("author") String author);
}
