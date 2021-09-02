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

create table `producto`(
  `id` int(11) not null auto_increment,
  `nombre` varchar(50),
  `descripcion` varchar(50),
  `tipo` varchar(50),
  `precio` float(20),
  primary key(`id`)
) engine = InnoDB auto_increment = 1 default charset = latin1;

create table `productoxNegocio`(
  `idNegocio` int(11) not null,
  `idProducto` int(11) not null,
  FOREIGN KEY (idNegocio) REFERENCES negocio(id),
	FOREIGN KEY (idProducto) REFERENCES producto(id),
	PRIMARY KEY (idNegocio, idProducto)
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


insert into `producto` values (1,'hamburguesa simple','hamburguesa con queso','hamburguesa', 180.50);
insert into `producto` values (2,'hamburguesa completa','hamburguesa con queso, huevo, lechuga, tomate','hamburguesa', 250.00);
insert into `producto` values (3,'hamburguesa doble inglesa','hamburguesa con estilo ingles y doble de carne','hamburguesa', 500.00);
insert into `producto` values (4,'sandwich de milanesa (carne)','sandwich de milanesa con queso, lechuga y tomate','sandwich', 350.50);
insert into `producto` values (5,'sandwich de jamon y queso','un sandwich','sandwich', 255.50);
insert into `producto` values (6,'sandwich de milanesa (pollo)','lo mismo que de carne pero de pollo','sandwich', 300.00);
insert into `producto` values (7,'cono de helado','helado de vainilla','helado', 100.00);

insert into `productoxNegocio` values (1,1);
insert into `productoxNegocio` values (2,2);
insert into `productoxNegocio` values (3,3);
insert into `productoxNegocio` values (4,4);
insert into `productoxNegocio` values (5,5);
insert into `productoxNegocio` values (6,6);
insert into `productoxNegocio` values (7,7);
