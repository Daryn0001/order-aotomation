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

ALTER TABLE event
    ADD COLUMN IF NOT EXISTS image jsonb DEFAULT NULL,

    DROP COLUMN IF EXISTS body,

    ALTER COLUMN description SET DEFAULT NULL,
    ALTER COLUMN description DROP NOT NULL,

    ALTER COLUMN places_uuid SET DEFAULT NULL,
    ALTER COLUMN places_uuid DROP NOT NULL,

    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;

