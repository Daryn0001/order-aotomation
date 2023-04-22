CREATE TABLE IF NOT EXISTS users
(
    uuid       varchar NOT NULL,
    fullname   varchar NOT NULL,
    phone      varchar NOT NULL,
    password varchar NOT NULL,
    email      varchar NOT NULL,
    role_uuid  varchar NOT NULL,
    CONSTRAINT unq_users_uuid UNIQUE (uuid),
    CONSTRAINT pk_users PRIMARY KEY (uuid)
);
