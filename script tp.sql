drop database if exists `db-pedidos`;
create database if not exists `db-pedidos`;
use `db-pedidos`;
drop table if exists `negocio`;
create table `negocio`(
  `id` int(11) not null auto_increment,
  `nombre` varchar(50),
  `direccion` varchar(50),
  `localidad` varchar(50),
  primary key(`id`)
) engine = InnoDB auto_increment = 1 default charset = latin1;


insert into `negocio` values (1,'nombre1','direccion1','banfield');
insert into `negocio` values (2,'nombre2','direccion2','banfield');
insert into `negocio` values (3,'nombre3','direccion3','banfield');
insert into `negocio` values (4,'nombre4','direccion4','banfield');
insert into `negocio` values (5,'nombre5','direccion5','lanus');
insert into `negocio` values (6,'nombre6','direccion6','lanus');
insert into `negocio` values (7,'nombre7','direccion7','avellaneda');
insert into `negocio` values (8,'nombre8','direccion8','lomas');
insert into `negocio` values (9,'nombre9','direccion9','lomas');
insert into `negocio` values (10,'nombre10','direccion10','lomas');