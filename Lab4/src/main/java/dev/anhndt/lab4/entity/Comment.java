package dev.anhndt.lab4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
//
//    @ManyToOne
//    private Post post;
}
