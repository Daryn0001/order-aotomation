CREATE TABLE IF NOT EXISTS place
(
    uuid varchar NOT NULL,
    name varchar NOT NULL,
    slug varchar NOT NULL,
    CONSTRAINT unq_places_uuid UNIQUE (uuid),
    CONSTRAINT pk_places PRIMARY KEY (uuid)
);
