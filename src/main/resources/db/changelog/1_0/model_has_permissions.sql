CREATE TABLE IF NOT EXISTS model_has_permissions
(
    permission_id bigint       NOT NULL,
    model_type    varchar(255) NOT NULL,
    model_id      bigint       NOT NULL,
    PRIMARY KEY (permission_id, model_id, model_type)
);
