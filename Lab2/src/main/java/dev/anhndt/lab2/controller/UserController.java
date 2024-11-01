package dev.anhndt.lab2.controller;

import dev.anhndt.lab2.entity.dto.PostDto;
import dev.anhndt.lab2.entity.dto.UserDto;
import dev.anhndt.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:8080"})
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        var user = this.userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createNewUser(@RequestBody UserDto userDto) {
        this.userService.createUser(userDto);
    }

    @GetMapping("/filter")
    public List<UserDto> getAllUserHasMoreThanOnePost() {
        return this.userService.getAllUserHasMoreThanOnePost();
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getAllPostByUserId(@PathVariable long id) {
        return this.userService.getAllPostsByUserId(id);
    }

}
