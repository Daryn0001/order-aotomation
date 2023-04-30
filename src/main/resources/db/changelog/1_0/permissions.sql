CREATE TABLE IF NOT EXISTS permissions
(
    id         bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       varchar(255) NOT NULL,
    guard_name varchar(255) NOT NULL,
    created_at timestamp    NULL DEFAULT NULL,
    updated_at timestamp    NULL DEFAULT NULL,
    CONSTRAINT permissions_name_guard_name_unique UNIQUE (name, guard_name)
);