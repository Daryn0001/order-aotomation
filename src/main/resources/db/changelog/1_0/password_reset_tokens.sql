CREATE TABLE IF NOT EXISTS password_reset_tokens
(
    email      varchar(255) NOT NULL,
    token      varchar(255) NOT NULL,
    created_at timestamp    NULL DEFAULT NULL,
    PRIMARY KEY (email)
)