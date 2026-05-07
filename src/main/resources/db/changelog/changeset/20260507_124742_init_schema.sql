--liquibase formatted sql

--changeset Pavel Filatov:20260507_124742_init_schema

CREATE TABLE IF NOT EXISTS manufacturers
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    serial_number   VARCHAR(256) UNIQUE               NOT NULL,
    manufacturer_id INT REFERENCES manufacturers (id) NOT NULL,
    price           NUMERIC(10, 2)                    NOT NULL DEFAULT (0.0),
    stock           INT                               NOT NULL DEFAULT (0)                     NOT NULL
);

CREATE TABLE IF NOT EXISTS desktop_computers
(
    product_id  INT,
    form_factor VARCHAR(64) NOT NULL,
    FOREIGN KEY (product_id) references products (id)
);

CREATE TABLE IF NOT EXISTS laptops
(
    product_id  INT,
    screen_size INT NOT NULL,
    CONSTRAINT valid_screen_size CHECK ( screen_size in (13, 14, 15, 17) ),
    FOREIGN KEY (product_id) references products (id)
);

CREATE TABLE IF NOT EXISTS monitors
(
    product_id INT,
    diagonal   FLOAT,
    constraint valid_diagonal CHECK ( diagonal > 0.0 ),
    FOREIGN KEY (product_id) references products (id)
);

CREATE TABLE IF NOT EXISTS hard_drives
(
    product_id INT,
    capacity   BIGINT NOT NULL CHECK (capacity > 0),
    FOREIGN KEY (product_id) references products (id)
);

COMMENT ON COLUMN monitors.diagonal IS 'В дюймах';
COMMENT ON COLUMN hard_drives.capacity IS 'В байтах';