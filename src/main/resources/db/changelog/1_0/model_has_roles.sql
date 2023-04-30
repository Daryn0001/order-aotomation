CREATE TABLE IF NOT EXISTS model_has_roles
(
    role_id    bigint       NOT NULL,
    model_type varchar(255) NOT NULL,
    model_id   bigint       NOT NULL,
    PRIMARY KEY (role_id, model_id, model_type)
);
