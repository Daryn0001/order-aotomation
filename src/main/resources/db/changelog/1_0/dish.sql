CREATE TABLE IF NOT EXISTS dishes
(
    uuid VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    pictures TEXT NOT NULL,
    ingredients TEXT NOT NULL,
    amount integer NOT NULL,
    notes TEXT NOT NULL,
    body TEXT NOT NULL,
    price varchar(255) not null,
    category_id INT NOT NULL,
    PRIMARY KEY (uuid)
);

ALTER TABLE dishes
    ADD COLUMN IF NOT EXISTS is_active boolean NOT NULL default false,
    ADD COLUMN IF NOT EXISTS amount INTEGER NOT NULL default '0',
    ALTER COLUMN price TYPE VARCHAR(255),

    ALTER COLUMN description SET DEFAULT NULL,
    ALTER COLUMN description DROP NOT NULL,

    ALTER COLUMN notes SET DEFAULT NULL,
    ALTER COLUMN notes DROP NOT NULL,

    ALTER COLUMN category_id SET DEFAULT NULL,
    ALTER COLUMN category_id DROP NOT NULL,

    DROP COLUMN IF EXISTS pictures,
    DROP COLUMN IF EXISTS ingredients,
    DROP COLUMN IF EXISTS body;

ALTER TABLE dishes
    ADD COLUMN IF NOT EXISTS pictures JSON DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS ingredients JSON DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS created_at timestamp NULL DEFAULT NULL,
    ADD COLUMN IF NOT EXISTS updated_at timestamp NULL DEFAULT NULL;
