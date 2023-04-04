CREATE TABLE IF NOT EXISTS companies
(
    uuid        varchar(255) NOT NULL,
    name        varchar(255) NOT NULL,
    description varchar      NOT NULL,
    address     varchar      NOT NULL,
    phone       varchar      NOT NULL,
    owner_uuid  varchar      NOT NULL,
    CONSTRAINT unq_companies_uuid UNIQUE (uuid),
    CONSTRAINT pk_companies PRIMARY KEY (uuid)
);
