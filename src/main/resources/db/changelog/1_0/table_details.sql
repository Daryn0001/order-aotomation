CREATE TABLE IF NOT EXISTS table_details
(
    uuid          VARCHAR(254) NOT NULL,
    floor         INT,
    internal_id   VARCHAR(254) NOT NULL,
    temporary_key VARCHAR(255) NOT NULL,

    PRIMARY KEY (uuid)
);