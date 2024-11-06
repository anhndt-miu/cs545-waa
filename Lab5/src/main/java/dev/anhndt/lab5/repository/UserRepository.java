package dev.anhndt.lab5.repository;

import dev.anhndt.lab5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where size(u.posts)> :count")
    List<User> findAllByPostsIsGreaterThan(Long count);

    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findAllByPostWithGivenTitle(@Param("title") String title);

}
