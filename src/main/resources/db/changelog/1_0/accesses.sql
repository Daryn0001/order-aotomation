CREATE TABLE IF NOT EXISTS accesses
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    branch_uuid varchar NOT NULL,
    user_uuid   varchar NOT NULL
);
