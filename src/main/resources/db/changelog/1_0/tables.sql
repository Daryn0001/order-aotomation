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
    DROP COLUMN IF EXISTS floor;