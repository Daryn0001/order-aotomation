CREATE TABLE IF NOT EXISTS dish
(
    uuid VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    pictures TEXT NOT NULL,
    ingredients TEXT NOT NULL,
    amount integer NOT NULL,
    notes TEXT NOT NULL,
    body TEXT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (uuid)
);