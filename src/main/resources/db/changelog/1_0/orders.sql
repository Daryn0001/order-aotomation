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
