package dev.anhndt.lab5.controller;

import dev.anhndt.lab5.aspect.annotation.ExecutionTime;
import dev.anhndt.lab5.entity.dto.CommentDto;
import dev.anhndt.lab5.entity.dto.PostDto;
import dev.anhndt.lab5.entity.dto.UserDto;
import dev.anhndt.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.userService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        var user = this.userService.findById(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createNewUser(@RequestBody UserDto userDto) {
        this.userService.createUser(userDto);
    }

    @GetMapping("/posts/greater-than/{count}")
    public List<UserDto> getAllUserHasMoreThanNPost(@PathVariable long count) {
        return this.userService.getAllUserHasMoreThanNPost(count);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getAllPostByUserId(@PathVariable long id) {
        return this.userService.getAllPostsByUserId(id);
    }

    @GetMapping("/find-by-post")
    public List<UserDto> findAllByPostWithGivenTitle(@RequestParam String title) {
        return this.userService.findAllByPostWithGivenTitle(title);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentsByUserAndPost(@PathVariable long userId, @PathVariable long postId, @PathVariable long commentId) {
        CommentDto comment = this.userService.getCommentByUserAndPost(userId, postId, commentId);
        if (comment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        if (this.userService.findById(id) != null) {
            this.userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/exception")
    public ResponseEntity<Void> exception() {
        this.userService.exceptionTest();
        return ResponseEntity.internalServerError().build();
    }

}
