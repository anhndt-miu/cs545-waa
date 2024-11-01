package dev.anhndt.lab2.controller;

import dev.anhndt.lab2.entity.dto.PostDto;
import dev.anhndt.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = {"http://localhost:8080"})
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        var post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable long id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
    }

    @GetMapping("/author/filter")
    public List<PostDto> getPostsByAuthor(@RequestParam String author) {
        return postService.filterByAuthor(author);
    }

    @GetMapping("/search")
    public List<PostDto> getPostsByAuthorText(@RequestParam String text) {
        return postService.filterByAuthorContainsWord(text);
    }
}
