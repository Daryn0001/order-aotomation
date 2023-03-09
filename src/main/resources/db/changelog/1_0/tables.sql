CREATE TABLE IF NOT EXISTS tables
(
    uuid          VARCHAR(254) NOT NULL,
    floor         INT,
    intermal_id   VARCHAR(254) NOT NULL,
    temporary_key VARCHAR(255) NOT NULL,

    PRIMARY KEY (uuid)
);