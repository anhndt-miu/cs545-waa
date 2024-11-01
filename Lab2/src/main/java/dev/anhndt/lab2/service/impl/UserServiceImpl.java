package dev.anhndt.lab2.service.impl;

import dev.anhndt.lab2.entity.User;
import dev.anhndt.lab2.entity.dto.PostDto;
import dev.anhndt.lab2.entity.dto.UserDto;
import dev.anhndt.lab2.helper.ListMapper;
import dev.anhndt.lab2.repository.UserRepository;
import dev.anhndt.lab2.service.UserService;
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

    @Override
    public List<UserDto> findAll() {
        return listMapper.mapList(this.userRepository.findAll(), UserDto.class);
    }

    @Override
    public UserDto findById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw new RuntimeException("Can not find user with id: " + id);
    }

    @Override
    public void createUser(UserDto user) {
        this.userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public List<UserDto> getAllUserHasMoreThanOnePost() {
        List<User> data = this.userRepository.findAllByPostsIsGreaterThan(1L);
        return listMapper.mapList(data, UserDto.class);
//        return List.of();
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long userId) {
        UserDto user = this.findById(userId);
        return listMapper.mapList(user.getPosts(), PostDto.class);
    }
}
