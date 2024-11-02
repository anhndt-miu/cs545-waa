package dev.anhndt.lab4.service.impl;

import dev.anhndt.lab4.entity.Comment;
import dev.anhndt.lab4.entity.User;
import dev.anhndt.lab4.entity.dto.CommentDto;
import dev.anhndt.lab4.entity.dto.PostDto;
import dev.anhndt.lab4.entity.dto.UserDto;
import dev.anhndt.lab4.exception.UserNotFoundException;
import dev.anhndt.lab4.helper.ListMapper;
import dev.anhndt.lab4.repository.CommentRepository;
import dev.anhndt.lab4.repository.UserRepository;
import dev.anhndt.lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<UserDto> findAll() {
        return listMapper.mapList(this.userRepository.findAll(), UserDto.class);
    }

    @Override
    public UserDto findById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
    }

    @Override
    public void createUser(UserDto user) {
        this.userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public List<UserDto> getAllUserHasMoreThanNPost(long count) {
        List<User> data = this.userRepository.findAllByPostsIsGreaterThan(count);
        return listMapper.mapList(data, UserDto.class);
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long userId) {
        UserDto user = this.findById(userId);
        return listMapper.mapList(user.getPosts(), PostDto.class);
    }

    @Override
    public List<UserDto> findAllByPostWithGivenTitle(String title) {
        List<User> data = this.userRepository.findAllByPostWithGivenTitle(title);
        return listMapper.mapList(data, UserDto.class);
    }

    @Override
    public CommentDto getCommentByUserAndPost(long userId, long postId, long commentId) {
        Optional<Comment> comment = this.commentRepository.getCommentByUserAndPost(userId, postId, commentId);
        return comment.map(value -> modelMapper.map(value, CommentDto.class)).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        try {
            Optional<User> user = this.userRepository.findById(id);
            if (user.isPresent()) {
                // Just call delete user
                // All relation data will delete due to `cascade = Remove | ALL` << check User object annotation
                this.userRepository.deleteById(id);
            }

            throw new UserNotFoundException(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void exceptionTest() {
        throw new RuntimeException("Throw exception");
    }
}
