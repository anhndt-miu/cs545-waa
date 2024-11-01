INSERT INTO Users (name)
VALUES ('Alice'),
       ('Bob'),
       ('Carol'),
       ('Dave'),
       ('Eve'),
       ('Frank'),
       ('Grace'),
       ('Hannah'),
       ('Ivy'),
       ('Jack');

INSERT INTO Post (title, content, author, user_id)
VALUES ('Java Basics', 'This post covers the basics of Java programming.', 'Alice', 1),
       ('Spring Boot Guide', 'A guide on building REST APIs with Spring Boot.', 'Bob', 2),
       ('Hibernate ORM', 'An introduction to ORM with Hibernate in Java.', 'Carol', 3),
       ('Advanced Java', 'Deep dive into advanced Java concepts and features.', 'Dave', 4),
       ('Microservices Architecture', 'Overview of microservices architecture using Spring Cloud.', 'Eve', 5),
       ('Java Concurrency', 'Introduction to concurrency and multithreading in Java.', 'Frank', 6),
       ('Database Transactions', 'A comprehensive guide to handling transactions in Java.', 'Grace', 7),
       ('RESTful API Design', 'Best practices for designing RESTful APIs.', 'Hannah', 8),
       ('Effective Java', 'Key insights from the book Effective Java by Joshua Bloch.', 'Ivy', 9),
       ('Unit Testing with JUnit', 'How to write unit tests in Java using JUnit framework.', 'Ivy', 9);