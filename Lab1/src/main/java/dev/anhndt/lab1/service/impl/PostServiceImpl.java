package dev.anhndt.lab1.service.impl;

import dev.anhndt.lab1.entity.Post;
import dev.anhndt.lab1.entity.dto.PostDto;
import dev.anhndt.lab1.helper.ListMapper;
import dev.anhndt.lab1.repository.PostRepository;
import dev.anhndt.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return listMapper.mapList(postRepository.getAllPosts(), PostDto.class);
    }

    @Override
    public PostDto getPostById(long id) {
        return modelMapper.map(postRepository.getPostById(id), PostDto.class);
    }

    @Override
    public void createPost(PostDto post) {
        postRepository.createPost(modelMapper.map(post, Post.class));
    }

    @Override
    public void updatePost(long id, PostDto post) {
        postRepository.updatePost(id, modelMapper.map(post, Post.class));
    }

    @Override
    public void deletePost(long id) {
        postRepository.deletePost(id);
    }

    @Override
    public List<PostDto> filterByAuthor(String author) {
        return listMapper.mapList(postRepository.filterByAuthor(author), PostDto.class);
    }

    @Override
    public List<PostDto> filterByAuthorContainsWord(String author) {
        return listMapper.mapList(postRepository.filterByAuthorContainWord(author), PostDto.class);
    }
}
