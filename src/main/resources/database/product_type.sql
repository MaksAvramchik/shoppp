CREATE TABLE IF NOT EXISTS product_type
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    Product BIGSERIAL NOT NULL ,
    price VARCHAR(20)  NOT NULL,
    old_price VARCHAR(20)  NOT NULL,
    image VARCHAR(20)  NOT NULL,
    description VARCHAR(200)  NOT NULL
    );