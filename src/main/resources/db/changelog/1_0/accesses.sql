CREATE TABLE IF NOT EXISTS accesses
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    branch_uuid varchar NOT NULL,
    user_id   varchar NOT NULL
);

ALTER TABLE accesses
    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL,
    ALTER COLUMN user_id TYPE bigint USING user_id::bigint;
