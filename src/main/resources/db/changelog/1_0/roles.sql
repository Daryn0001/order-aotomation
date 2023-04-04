CREATE TABLE IF NOT EXISTS roles
(
    uuid  varchar NOT NULL,
    title varchar NOT NULL,
    CONSTRAINT unq_roles_uuid UNIQUE (uuid),
    CONSTRAINT pk_roles PRIMARY KEY (uuid)
);
