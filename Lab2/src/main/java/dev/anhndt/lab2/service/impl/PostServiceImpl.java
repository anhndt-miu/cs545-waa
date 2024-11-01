package dev.anhndt.lab2.service.impl;

import dev.anhndt.lab2.entity.Post;
import dev.anhndt.lab2.entity.dto.PostDto;
import dev.anhndt.lab2.helper.ListMapper;
import dev.anhndt.lab2.repository.PostRepository;
import dev.anhndt.lab2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        return listMapper.mapList(postRepository.findAll(), PostDto.class);
    }

    @Override
    public PostDto getPostById(long id) {
        var post = postRepository.findById(id);
        if (post.isPresent()) {
            return modelMapper.map(post.get(), PostDto.class);
        }
        throw new RuntimeException("Can not find post with id: " + id);
    }

    @Override
    public void createPost(PostDto post) {
        postRepository.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void updatePost(long id, PostDto post) {
        Optional<Post> checkingPost = postRepository.findById(id);
        if (checkingPost.isPresent()) {
            Post data = checkingPost.get();
            data.setTitle(post.getTitle());
            data.setContent(post.getContent());
            postRepository.save(data);
        }
        throw new RuntimeException("Can not find post with id: " + id);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> filterByAuthor(String author) {
        return this.findAll().stream().filter(x -> x.getAuthor().equals(author)).toList();
    }

    @Override
    public List<PostDto> filterByAuthorContainsWord(String author) {
        return this.findAll().stream().filter(x -> x.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
    }
}
