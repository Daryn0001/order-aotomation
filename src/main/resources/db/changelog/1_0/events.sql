CREATE TABLE IF NOT EXISTS event
(
    uuid        varchar NOT NULL,
    title       varchar NOT NULL,
    description text    NOT NULL,
    body        varchar NOT NULL,
    places_uuid varchar NOT NULL,
    CONSTRAINT unq_events_uuid UNIQUE (uuid),
    CONSTRAINT pk_events PRIMARY KEY (uuid)
);
