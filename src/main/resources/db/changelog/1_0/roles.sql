CREATE TABLE IF NOT EXISTS roles
(
    id         bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       varchar   NOT NULL,
    guard_name varchar   NOT NULL,
    created_at timestamp NULL DEFAULT NOW(),
    updated_at timestamp NULL DEFAULT NULL,
    CONSTRAINT unq_roles_uuid UNIQUE (id)
);
