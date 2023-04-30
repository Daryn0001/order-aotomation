CREATE TABLE IF NOT EXISTS tables
(
    uuid          VARCHAR(254) NOT NULL,
    floor         INT,
    internal_id   VARCHAR(254) NOT NULL,
    temporary_key VARCHAR(255) NOT NULL,

    PRIMARY KEY (uuid)
);

ALTER TABLE IF EXISTS tables
    ADD COLUMN IF NOT EXISTS branch_uuid VARCHAR(254) NOT NULL default '',
    DROP COLUMN IF EXISTS floor,

    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;