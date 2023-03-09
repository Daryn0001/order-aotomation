ALTER TABLE orders
    ADD CONSTRAINT fk_orders_tables FOREIGN KEY (table_uuid) REFERENCES tables (uuid),
    ADD CONSTRAINT fk_orders_booking FOREIGN KEY (booking_uuid) REFERENCES booking (uuid);

ALTER TABLE baskets
    ADD CONSTRAINT fk_baskets_dishes FOREIGN KEY (dish_uuid) REFERENCES dishes (uuid),
    ADD CONSTRAINT fk_baskets_orders FOREIGN KEY (order_uuid) REFERENCES orders (uuid);

ALTER TABLE dishes
    ADD CONSTRAINT fk_dishes_categories FOREIGN KEY (category_id) REFERENCES categories (id);