package dev.anhndt.lab4.service.impl;

import dev.anhndt.lab4.entity.Comment;
import dev.anhndt.lab4.entity.Post;
import dev.anhndt.lab4.entity.dto.CommentDto;
import dev.anhndt.lab4.entity.dto.PostDto;
import dev.anhndt.lab4.helper.ListMapper;
import dev.anhndt.lab4.repository.CommentRepository;
import dev.anhndt.lab4.repository.PostRepository;
import dev.anhndt.lab4.service.PostService;
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
    private final CommentRepository commentRepository;

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
        return post.map(value -> modelMapper.map(value, PostDto.class)).orElse(null);
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

    @Override
    public List<PostDto> findPostsByTitle(String title) {
        return listMapper.mapList(this.postRepository.findByTitle(title), PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return listMapper.mapList(this.postRepository.findByAuthor(author), PostDto.class);
    }

    @Override
    public CommentDto addComment(long postId, CommentDto comment) {
        try {
            Optional<Post> post = this.postRepository.findById(postId);
            if (post.isPresent()) {
                Post data = post.get();

                Comment cmt = modelMapper.map(comment, Comment.class);
                var res = this.commentRepository.save(cmt);
                data.getComments().add(res);
                this.postRepository.save(data);

                /// BiDirection
//                Comment cmt = modelMapper.map(comment, Comment.class);
//                cmt.setPost(data);
//                var res = this.commentRepository.save(cmt);

                return modelMapper.map(res, CommentDto.class);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
