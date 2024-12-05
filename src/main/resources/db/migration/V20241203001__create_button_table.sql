CREATE TABLE button (
    id BIGINT PRIMARY KEY,
    is_active BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO button (id, is_active) VALUES (1, FALSE);
