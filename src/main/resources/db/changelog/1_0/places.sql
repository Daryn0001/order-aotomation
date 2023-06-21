CREATE TABLE IF NOT EXISTS places
(
    uuid varchar NOT NULL,
    type varchar NOT NULL,
    size varchar NOT NULL,
    name varchar NOT NULL default '',
    branch_uuid varchar NOT NULL DEFAULT '',
    CONSTRAINT unq_places_uuid UNIQUE (uuid),
    CONSTRAINT pk_places PRIMARY KEY (uuid)
);

ALTER TABLE IF EXISTS place
    RENAME TO places;