package dev.anhndt.lab2.repository;

import dev.anhndt.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join u.posts p group by u having count(p) > :count")
    List<User> findAllByPostsIsGreaterThan(Long count);
}
