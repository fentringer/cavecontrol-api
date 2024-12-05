CREATE TABLE comment (
    id BIGINT PRIMARY KEY,
    content TEXT NOT NULL DEFAULT ''
);

INSERT INTO comment (id, content) VALUES (1, '');