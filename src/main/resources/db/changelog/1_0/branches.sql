CREATE TABLE IF NOT EXISTS branches
(
    uuid       varchar      NOT NULL,
    name       varchar      NOT NULL,
    address    varchar      NOT NULL,
    admin_id varchar(255) NOT NULL,
    company_uuid varchar(255) NOT NULL,
    CONSTRAINT unq_branches_uuid UNIQUE (uuid),
    CONSTRAINT pk_branches PRIMARY KEY (uuid)
);

ALTER TABLE branches
    ALTER COLUMN admin_id TYPE bigint USING admin_id::bigint;


ALTER TABLE branches
    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;