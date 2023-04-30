CREATE TABLE IF NOT EXISTS elements
(
    uuid       varchar NOT NULL,
    dish_uuid  varchar NOT NULL,
    event_uuid varchar NOT NULL,
    CONSTRAINT unq_elements_uuid UNIQUE (uuid),
    CONSTRAINT pk_elements PRIMARY KEY (uuid)
);

ALTER TABLE elements
    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;