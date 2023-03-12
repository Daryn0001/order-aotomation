ALTER TABLE order_details
    ADD CONSTRAINT fk_orders_tables FOREIGN KEY (table_uuid) REFERENCES table_details (uuid),
    ADD CONSTRAINT fk_orders_booking FOREIGN KEY (booking_uuid) REFERENCES booking (uuid);

ALTER TABLE basket
    ADD CONSTRAINT fk_baskets_dishes FOREIGN KEY (dish_uuid) REFERENCES dish (uuid),
    ADD CONSTRAINT fk_baskets_orders FOREIGN KEY (order_uuid) REFERENCES order_details (uuid);

ALTER TABLE dish
    ADD CONSTRAINT fk_dishes_categories FOREIGN KEY (category_id) REFERENCES category (id);