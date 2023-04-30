CREATE TABLE IF NOT EXISTS role_has_permissions
(
    permission_id bigint NOT NULL,
    role_id       bigint NOT NULL,
    PRIMARY KEY (permission_id, role_id)

);

CREATE INDEX IF NOT EXISTS role_has_permissions_role_id_index ON role_has_permissions (role_id);