CREATE TABLE IF NOT EXISTS companies
(
    uuid        varchar(255) NOT NULL,
    name        varchar(255) NOT NULL,
    description varchar      NOT NULL,
    address     varchar      NOT NULL,
    phone       varchar      NOT NULL,
    owner_id  varchar      NOT NULL,
    CONSTRAINT unq_companies_uuid UNIQUE (uuid),
    CONSTRAINT pk_companies PRIMARY KEY (uuid)
);

ALTER TABLE companies
ALTER COLUMN owner_id TYPE bigint USING owner_id::bigint;

ALTER TABLE companies
    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;