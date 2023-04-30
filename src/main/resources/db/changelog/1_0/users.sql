CREATE TABLE IF NOT EXISTS users
(
    id             bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fullname       varchar   NOT NULL,
    phone          varchar            DEFAULT NULL,
    password       varchar   NOT NULL,
    email          varchar            DEFAULT NULL,
    role_uuid      varchar   NOT NULL,
    is_active      boolean   NOT NULL DEFAULT false,
    remember_token varchar(100),
    created_at     timestamp NULL     DEFAULT NULL,
    updated_at     timestamp NULL     DEFAULT NULL,
    CONSTRAINT unq_users_uuid UNIQUE (id)
);

ALTER TABLE users DROP COLUMN IF EXISTS role_uuid;
