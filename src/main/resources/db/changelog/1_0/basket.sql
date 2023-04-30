CREATE TABLE IF NOT EXISTS basket
(
    uuid varchar(255) NOT NULL,
    amount integer NOT NULL,
    dish_uuid varchar(255) NOT NULL,
    order_uuid varchar(255) NOT NULL,
    PRIMARY KEY (uuid)
);

ALTER TABLE basket
ADD COLUMN IF NOT EXISTS
    created_at timestamp NULL DEFAULT NULL,
ADD COLUMN IF NOT EXISTS
    updated_at timestamp NULL DEFAULT NULL;
