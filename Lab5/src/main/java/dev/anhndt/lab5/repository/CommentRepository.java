package dev.anhndt.lab5.repository;

import dev.anhndt.lab5.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM User u " +
            "JOIN u.posts p " +
            "JOIN p.comments c " +
            "WHERE u.id = :userId AND p.id = :postId AND c.id = :commentId")
    Optional<Comment> getCommentByUserAndPost(long userId, long postId, long commentId);
}
