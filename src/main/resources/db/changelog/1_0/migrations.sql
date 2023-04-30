CREATE TABLE IF NOT EXISTS migrations
(
    id        INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    migration varchar(255) not null,
    batch     int          not null
);
