package dev.anhndt.lab3.controller;

import dev.anhndt.lab3.entity.dto.CommentDto;
import dev.anhndt.lab3.entity.dto.PostDto;
import dev.anhndt.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@CrossOrigin(origins = "*")
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
        if(post == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable long id) {
        if (this.postService.getPostById(id) != null) {
            postService.deletePost(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
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
    public List<PostDto> search(@RequestParam(required = false) String author, @RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return postService.findPostsByTitle(title);
        }

        if (author != null && !author.isEmpty()) {
            return postService.findPostsByAuthor(author);
        }

        return List.of();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable long postId, @RequestBody CommentDto comment) {
        var data = this.postService.addComment(postId, comment);
        if (data != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }

        return ResponseEntity.badRequest().build();
    }

}
