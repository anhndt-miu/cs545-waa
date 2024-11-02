package dev.anhndt.lab4.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    List<CommentDto> comments;
}
