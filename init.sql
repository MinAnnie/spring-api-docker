-- init.sql
CREATE TABLE IF NOT EXISTS products
(
    name
    VARCHAR
(
    100
),
    description TEXT,
    id serial CONSTRAINT id PRIMARY KEY
    );

-- Insertar 10 datos en la tabla products
INSERT INTO products (name, description)
VALUES ('Producto 1', 'Descripción del producto 1'),
       ('Producto 2', 'Descripción del producto 2'),
       ('Producto 3', 'Descripción del producto 3'),
       ('Producto 4', 'Descripción del producto 4'),
       ('Producto 5', 'Descripción del producto 5'),
       ('Producto 6', 'Descripción del producto 6'),
       ('Producto 7', 'Descripción del producto 7'),
       ('Producto 8', 'Descripción del producto 8'),
       ('Producto 9', 'Descripción del producto 9'),
       ('Producto 10', 'Descripción del producto 10');
