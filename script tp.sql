drop database if exists `db-pedidos`;
create database if not exists `db-pedidos`;
use `db-pedidos`;
drop table if exists `negocio`;
create table `negocio`(
  `idNegocio` int(11) not null auto_increment,
  `nombre` varchar(50),
  `direccion` varchar(50),
  `localidad` varchar(50),
  primary key(`idNegocio`)
) engine = InnoDB auto_increment = 1 default charset = latin1;

create table `producto`(
  `idProducto` int(11) not null auto_increment,
  `nombre` varchar(50),
  `descripcion` varchar(50),
  `tipo` varchar(50),
  `precio` float(20),
  `idNegocio` int(11) not null,
  primary key(`idProducto`), 
  key FK_idNegocio (idNegocio),
  constraint idNegocio
  foreign key (idNegocio) references negocio(idNegocio)
) engine = InnoDB auto_increment = 1 default charset = latin1;




