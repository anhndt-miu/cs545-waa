-- Insert data into Users table
INSERT INTO Users (name, email, password)
VALUES ('Alice Johnson', 'e1@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Bob Smith', 'e2@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Charlie Brown', 'e3@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Diana Prince', 'e4@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Ethan Hunt', 'e5@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Fiona Adams', 'e6@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('George Clark', 'e7@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Hannah Lee', 'e8@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Isaac Newton', 'e9@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'),
       ('Julia Roberts', 'e10@abc.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

-- Insert data into Posts table
INSERT INTO Post (title, content, author, user_id)
VALUES ('Exploring the Mountains', 'Today, I ventured into the Rockies and it was breathtaking.', 'Alice Johnson', 1),
       ('A Day at the Beach', 'Spent an amazing day by the ocean, enjoying the sun and waves.', 'Alice Johnson', 1),
       ('Tech Trends 2024', 'Discussing the future of AI and machine learning in the next decade.', 'Bob Smith', 2),
       ('Java Programming Tips', 'Best practices for writing clean and efficient Java code.', 'Bob Smith', 2),
       ('My First Marathon', 'Completed my first marathon and it was an unforgettable experience.', 'Charlie Brown', 3),
       ('Healthy Meal Prep Ideas', 'Here are some easy recipes for meal prepping healthy food.', 'Charlie Brown', 3),
       ('Traveling to Japan', 'Sharing my travel itinerary and tips for visiting Tokyo.', 'Diana Prince', 4),
       ('Photography', 'Tips for capturing stunning landscape photos.', 'Diana Prince', 4),
       ('Cybersecurity Basics', 'Understanding the importance of protecting personal data online.', 'Ethan Hunt', 5),
       ('Mission Accomplished', 'Reflecting on my recent project and lessons learned.', 'Ethan Hunt', 5);

-- Insert data into Comments table
INSERT INTO Comment (name, post_id)
VALUES ('Great insights, thanks for sharing!', 1),
       ('I love the mountains too! Any recommendations?', 1),
       ('This was really informative, I learned a lot.', 3),
       ('Do you think AI will replace developers?', 3),
       ('Congrats on the marathon! Inspiring.', 5),
       ('What was the hardest part of training?', 5),
       ('Thanks for the meal prep tips!', 6),
       ('Can’t wait to try these recipes.', 6),
       ('I’m planning a trip to Japan, this is helpful.', 7),
       ('What camera settings do you use?', 8);


-- Data for Role table
INSERT INTO Role (role)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1), -- Alice Johnson as ROLE_USER
       (1, 2), -- Alice Johnson as ROLE_ADMIN
       (2, 1); -- Bob Smith as ROLE_USER