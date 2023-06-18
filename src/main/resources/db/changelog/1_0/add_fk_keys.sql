ALTER TABLE orders
    DROP CONSTRAINT IF EXISTS fk_orders_tables;

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_tables FOREIGN KEY (table_uuid) REFERENCES tables (uuid);


ALTER TABLE baskets
    DROP CONSTRAINT IF EXISTS fk_baskets_dishes,
    DROP CONSTRAINT IF EXISTS fk_baskets_orders;

ALTER TABLE baskets
    ADD CONSTRAINT fk_baskets_dishes FOREIGN KEY (dish_uuid) REFERENCES dishes (uuid),
    ADD CONSTRAINT fk_baskets_orders FOREIGN KEY (order_uuid) REFERENCES orders (uuid);


ALTER TABLE dishes
    DROP CONSTRAINT IF EXISTS fk_dishes_categories;

ALTER TABLE dishes
    ADD CONSTRAINT fk_dishes_categories FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE categories
    DROP CONSTRAINT IF EXISTS fk_categories_branch_uuid;

ALTER TABLE categories
    ADD CONSTRAINT fk_categories_branch_uuid FOREIGN KEY (branch_uuid) REFERENCES branches (uuid);

ALTER TABLE events
    DROP CONSTRAINT IF EXISTS events_places_uuid_places_uuid;

ALTER TABLE events
    ADD CONSTRAINT events_places_uuid_places_uuid FOREIGN KEY (places_uuid) REFERENCES place (uuid);


ALTER TABLE elements
    DROP CONSTRAINT IF EXISTS Elements_dish_uuid_Dishes_uuid,
    DROP CONSTRAINT IF EXISTS Elements_event_uuid_Events_uuid;

ALTER TABLE elements
    ADD CONSTRAINT Elements_dish_uuid_Dishes_uuid  FOREIGN KEY  (dish_uuid) REFERENCES dishes (uuid),
    ADD CONSTRAINT Elements_event_uuid_Events_uuid FOREIGN KEY (event_uuid) REFERENCES events (uuid);


ALTER TABLE companies
    DROP CONSTRAINT IF EXISTS fk_companies_users;

ALTER TABLE companies
    ADD CONSTRAINT fk_companies_users FOREIGN KEY (owner_id) REFERENCES users (id);



ALTER TABLE tables
    DROP CONSTRAINT IF EXISTS fk_orders_branches;

ALTER TABLE tables
    ADD CONSTRAINT fk_orders_branches FOREIGN KEY (branch_uuid) REFERENCES branches (uuid);

ALTER TABLE accesses
    DROP CONSTRAINT IF EXISTS fk_accesses_branches,
    DROP CONSTRAINT IF EXISTS fk_accesses_users;

ALTER TABLE accesses
    ADD CONSTRAINT fk_accesses_branches FOREIGN KEY (branch_uuid) REFERENCES branches (uuid),
    ADD CONSTRAINT fk_accesses_users FOREIGN KEY (user_id) REFERENCES users (id);


ALTER TABLE branches
    DROP CONSTRAINT IF EXISTS fk_branches_companies,
    DROP CONSTRAINT IF EXISTS fk_branches_users;

ALTER TABLE branches
    ADD CONSTRAINT fk_branches_companies FOREIGN KEY (company_uuid) REFERENCES companies (uuid),
    ADD CONSTRAINT fk_branches_users FOREIGN KEY (admin_id) REFERENCES users (id);


ALTER TABLE model_has_permissions
    DROP CONSTRAINT IF EXISTS model_has_permissions_permission_id_foreign;

ALTER TABLE model_has_permissions
    ADD CONSTRAINT model_has_permissions_permission_id_foreign
        FOREIGN KEY (permission_id) REFERENCES permissions (id) ON DELETE CASCADE;


ALTER TABLE model_has_roles
    DROP CONSTRAINT IF EXISTS model_has_roles_role_id_foreign;

ALTER TABLE model_has_roles
    ADD CONSTRAINT model_has_roles_role_id_foreign
        FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE;


ALTER TABLE place
    DROP CONSTRAINT IF EXISTS places_branch_uuid_foreign;

ALTER TABLE place
    ADD CONSTRAINT places_branch_uuid_foreign
        FOREIGN KEY (branch_uuid) REFERENCES branches (uuid) ON DELETE CASCADE;


ALTER TABLE role_has_permissions
    DROP CONSTRAINT IF EXISTS role_has_permissions_permission_id_foreign,
    DROP CONSTRAINT IF EXISTS role_has_permissions_role_id_foreign;

ALTER TABLE role_has_permissions
    ADD CONSTRAINT role_has_permissions_permission_id_foreign
        FOREIGN KEY (permission_id) REFERENCES permissions (id) ON DELETE CASCADE,
    ADD CONSTRAINT role_has_permissions_role_id_foreign
        FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE;
