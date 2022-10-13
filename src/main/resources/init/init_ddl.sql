-- tb_product
CREATE TABLE IF NOT EXISTS `TB_PRODUCT`(
    id              bigint auto_increment primary key           comment 'id',
--  product_token   varchar(36)  not null                       comment 'product token',
    name            varchar(255) not null                       comment 'product name',
    description     varchar(255) null                           comment 'product description',
    status          varchar(30)  not null default 'PREPARED'    comment 'status',
    record_state    varchar(30)  not null default 'ACTIVE'      comment 'record_state',
    price           bigint default 0                            comment 'product price',
    created_date    datetime(6) null                            comment 'created date',
    updated_date    datetime(6) null                            comment 'updated date'
);

-- create
-- index tb_product_idx01 on tb_product (product_token);

create
index tb_product_idx02 on tb_product (created_date);

create
index tb_product_idx03 on tb_product (updated_date);