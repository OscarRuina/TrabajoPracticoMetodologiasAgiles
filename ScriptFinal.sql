drop database if exists `db-pedidos`;
create database if not exists `db-pedidos`;
use `db-pedidos`;

insert into roles
    (nombre)
values
    ("ROLE_VENDEDOR");
insert into roles
    (nombre)
values
    ("ROLE_COMPRADOR");
insert into roles
    (nombre)
values
    ("ROLE_REPARTIDOR");

