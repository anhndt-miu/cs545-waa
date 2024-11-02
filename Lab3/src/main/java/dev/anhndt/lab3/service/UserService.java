package dev.anhndt.lab3.service;

import dev.anhndt.lab3.entity.dto.CommentDto;
import dev.anhndt.lab3.entity.dto.PostDto;
import dev.anhndt.lab3.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void createUser(UserDto user);

    List<UserDto> getAllUserHasMoreThanNPost(long count);

    List<PostDto> getAllPostsByUserId(long userId);

    List<UserDto> findAllByPostWithGivenTitle(String title);

    CommentDto getCommentByUserAndPost(long userId, long postId, long commentId);

    void deleteUser(long id);
}
