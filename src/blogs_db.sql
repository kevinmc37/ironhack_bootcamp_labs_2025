USE blogs_db;

DROP TABLE IF EXISTS blogs;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE blogs (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    word_count INT NOT NULL,
    views INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO authors (id, name) VALUES
    (1, 'Maria Charlotte'),
    (2, 'Juan Perez'),
    (3, 'Gemma Alcocer');

INSERT INTO blogs (id, title, author_id, word_count, views) VALUES
    (1, 'Best Paint Colors', 1, 814, 14),
    (2, 'Small Space Decorating Tips', 2, 1146, 221),
    (3, 'Hot Accessories', 1, 986, 105),
    (4, 'Mixing Textures', 1, 765, 22),
    (5, 'Kitchen Refresh', 2, 1242, 307),
    (6, 'Homemade Art Hacks', 1, 1002, 193),
    (7, 'Refinishing Wood Floors', 3, 1571, 7542);

SELECT b.title, a.name AS author, word_count, views FROM blogs b
INNER JOIN authors a ON b.author_id = a.id;
