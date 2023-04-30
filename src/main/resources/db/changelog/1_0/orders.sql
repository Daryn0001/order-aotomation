CREATE TABLE IF NOT EXISTS orders
(
    uuid         VARCHAR(254) NOT NULL,
    phone        VARCHAR(254) NOT NULL,
    name         VARCHAR(200) NOT NULL,
    booking_uuid VARCHAR(254) NOT NULL,
    table_uuid   VARCHAR(254) NOT NULL,
    price        INT          NOT NULL,
    PRIMARY KEY (uuid)
);

ALTER TABLE orders
    DROP COLUMN IF EXISTS booking_uuid,

    ADD COLUMN IF NOT EXISTS
        created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS
        updated_at timestamp NULL DEFAULT NULL;