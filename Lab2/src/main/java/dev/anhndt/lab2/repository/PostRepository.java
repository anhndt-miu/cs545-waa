package dev.anhndt.lab2.repository;

import dev.anhndt.lab2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
