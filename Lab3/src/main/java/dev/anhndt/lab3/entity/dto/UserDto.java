package dev.anhndt.lab3.entity.dto;

import dev.anhndt.lab3.entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    long id;
    String name;
    List<Post> posts;
}
