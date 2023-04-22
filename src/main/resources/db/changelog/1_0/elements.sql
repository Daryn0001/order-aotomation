CREATE TABLE IF NOT EXISTS elements
(
    uuid       varchar NOT NULL,
    dish_uuid  varchar NOT NULL,
    event_uuid varchar NOT NULL,
    CONSTRAINT unq_elements_uuid UNIQUE (uuid),
    CONSTRAINT pk_elements PRIMARY KEY (uuid)
);
