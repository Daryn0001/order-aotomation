CREATE TABLE IF NOT EXISTS personal_access_tokens
(
    id             bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tokenable_type varchar(255) NOT NULL,
    tokenable_id   bigint       NOT NULL,
    name           varchar(255) NOT NULL,
    token          varchar(64)  NOT NULL,
    abilities      text              DEFAULT NULL,
    last_used_at   timestamp    NULL DEFAULT NULL,
    expires_at     timestamp    NULL DEFAULT NULL,
    created_at     timestamp    NULL DEFAULT NULL,
    updated_at     timestamp    NULL DEFAULT NULL,
    CONSTRAINT personal_access_tokens_token_unique UNIQUE (token),
    CONSTRAINT personal_access_tokens_tokenable_type_tokenable_id_index UNIQUE (tokenable_type, tokenable_id)
);