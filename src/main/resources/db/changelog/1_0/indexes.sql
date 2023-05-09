CREATE INDEX IF NOT EXISTS events_uuid_index ON events (uuid);

CREATE INDEX IF NOT EXISTS dishes_uuid_index ON dishes (uuid);

CREATE INDEX IF NOT EXISTS categories_id_index ON categories (id);

CREATE INDEX IF NOT EXISTS orders_uuid_index ON orders (uuid);

CREATE INDEX IF NOT EXISTS tables_uuid_index ON tables (uuid);

CREATE INDEX IF NOT EXISTS elements_uuid_index ON elements (uuid);

CREATE INDEX IF NOT EXISTS elements_dish_uuid_index ON elements (dish_uuid);

CREATE INDEX IF NOT EXISTS elements_events_uuid_index ON elements (event_uuid);