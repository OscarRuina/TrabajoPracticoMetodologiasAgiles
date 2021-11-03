drop database if exists `db-pedidos`;
create database if not exists `db-pedidos`;

use `db-pedidos`;

create table `roles`(
  `role_id` int(11) not null auto_increment,
  `nombre` varchar(50),
  primary key(`role_id`)
) engine = InnoDB auto_increment = 1 default charset = latin1;

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

