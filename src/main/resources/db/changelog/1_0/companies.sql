CREATE TABLE IF NOT EXISTS companies
(
    uuid        varchar(255) NOT NULL,
    name        varchar(255) NOT NULL,
    description varchar      NOT NULL,
    address     varchar      NOT NULL,
    phone       varchar      NOT NULL,
    owner_uuid  varchar      NOT NULL,
    CONSTRAINT unq_companies_uuid UNIQUE (uuid),
    CONSTRAINT pk_companies PRIMARY KEY (uuid)
);

ALTER TABLE companies
ALTER COLUMN owner_uuid TYPE bigint USING owner_uuid::bigint;

ALTER TABLE companies
    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;