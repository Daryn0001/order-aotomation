CREATE TABLE IF NOT EXISTS booking
(
    uuid       VARCHAR(254) NOT NULL,
    phone      VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NOT NULL,
    time       TIMESTAMP    NOT NULL,
    table_uuid VARCHAR(254) NOT NULL,
    PRIMARY KEY (uuid)
);