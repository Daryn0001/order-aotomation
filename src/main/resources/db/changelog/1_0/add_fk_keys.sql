ALTER TABLE orders
    DROP CONSTRAINT IF EXISTS fk_orders_tables;

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_tables FOREIGN KEY (table_uuid) REFERENCES tables (uuid);


ALTER TABLE basket
    DROP CONSTRAINT IF EXISTS fk_baskets_dishes,
    DROP CONSTRAINT IF EXISTS fk_baskets_orders;

ALTER TABLE basket
    ADD CONSTRAINT fk_baskets_dishes FOREIGN KEY (dish_uuid) REFERENCES dish (uuid),
    ADD CONSTRAINT fk_baskets_orders FOREIGN KEY (order_uuid) REFERENCES orders (uuid);


ALTER TABLE dish
    DROP CONSTRAINT IF EXISTS fk_dishes_categories;

ALTER TABLE dish
    ADD CONSTRAINT fk_dishes_categories FOREIGN KEY (category_id) REFERENCES category (id);


ALTER TABLE event
    DROP CONSTRAINT IF EXISTS events_places_uuid_places_uuid;

ALTER TABLE event
    ADD CONSTRAINT events_places_uuid_places_uuid FOREIGN KEY (places_uuid) REFERENCES place (uuid);


ALTER TABLE elements
    DROP CONSTRAINT IF EXISTS Elements_dish_uuid_Dishes_uuid,
    DROP CONSTRAINT IF EXISTS Elements_event_uuid_Events_uuid;

ALTER TABLE elements
    ADD CONSTRAINT Elements_dish_uuid_Dishes_uuid  FOREIGN KEY  (dish_uuid) REFERENCES dish (uuid),
    ADD CONSTRAINT Elements_event_uuid_Events_uuid FOREIGN KEY (event_uuid) REFERENCES event (uuid);


ALTER TABLE users
    DROP CONSTRAINT IF EXISTS fk_users_roles;

ALTER TABLE users
    ADD CONSTRAINT fk_users_roles FOREIGN KEY (role_uuid) REFERENCES roles (uuid);


ALTER TABLE companies
    DROP CONSTRAINT IF EXISTS fk_companies_users;

ALTER TABLE companies
    ADD CONSTRAINT fk_companies_users FOREIGN KEY (owner_uuid) REFERENCES users (uuid);



ALTER TABLE tables
    DROP CONSTRAINT IF EXISTS fk_orders_branches;

ALTER TABLE tables
    ADD CONSTRAINT fk_orders_branches FOREIGN KEY (branch_uuid) REFERENCES branches (uuid);

ALTER TABLE accesses
    DROP CONSTRAINT IF EXISTS fk_accesses_branches,
    DROP CONSTRAINT IF EXISTS fk_accesses_users;

ALTER TABLE accesses
    ADD CONSTRAINT fk_accesses_branches FOREIGN KEY (branch_uuid) REFERENCES branches (uuid),
    ADD CONSTRAINT fk_accesses_users FOREIGN KEY (user_uuid) REFERENCES users (uuid);


ALTER TABLE branches
    DROP CONSTRAINT IF EXISTS fk_branches_companies,
    DROP CONSTRAINT IF EXISTS fk_branches_users;

ALTER TABLE branches
    ADD CONSTRAINT fk_branches_companies FOREIGN KEY (company_id) REFERENCES companies (uuid),
    ADD CONSTRAINT fk_branches_users FOREIGN KEY (admin_uuid) REFERENCES users (uuid);
