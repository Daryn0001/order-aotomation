CREATE TABLE IF NOT EXISTS dish
(
    uuid VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    pictures TEXT NOT NULL,
    ingredients TEXT NOT NULL,
    amount integer NOT NULL,
    note TEXT NOT NULL,
    price VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (uuid)
);

ALTER TABLE dish
    ADD COLUMN IF NOT EXISTS is_active boolean NOT NULL default false,
    ADD COLUMN IF NOT EXISTS amount INTEGER NOT NULL default '0',
    ALTER COLUMN price TYPE VARCHAR(255),
    DROP COLUMN IF EXISTS body;
