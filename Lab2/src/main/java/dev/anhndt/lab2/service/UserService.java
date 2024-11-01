package dev.anhndt.lab2.service;

import dev.anhndt.lab2.entity.dto.PostDto;
import dev.anhndt.lab2.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void createUser(UserDto user);

    List<UserDto> getAllUserHasMoreThanOnePost();

    List<PostDto> getAllPostsByUserId(long userId);
}
