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

insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(1,'nombre1','direccion1','banfield',1139658495);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(2,'nombre2','direccion2','banfield',1139601295);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(3,'nombre3','direccion3','banfield',1139622495);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(4,'nombre4','direccion4','banfield',1139650000);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(5,'nombre5','direccion5','lanus',1165658495);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(6,'nombre6','direccion6','lanus',1139658855);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(7,'nombre7','direccion7','avellaneda',1139338495);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(8,'nombre8','direccion8','lomas',1139320495);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(9,'nombre9','direccion9','lomas',1139653215);
insert into `negocio`(
id_negocio,
nombre,
direccion,
localidad,
telefono
) values
(10,'nombre10','direccion10','lomas',1189588495);

insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(1,'hamburguesa simple','hamburguesa con queso','hamburguesa', 180.50,1);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(2,'hamburguesa completa','hamburguesa con queso, huevo, lechuga, tomate','hamburguesa', 250.00,2);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(3,'hamburguesa doble inglesa','hamburguesa con estilo ingles y doble de carne','hamburguesa', 500.00,3);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(4,'sandwich de milanesa (carne)','sandwich de milanesa con queso, lechuga y tomate','sandwich', 350.50,4);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(5,'sandwich de jamon y queso','un sandwich','sandwich', 255.50,5);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(6,'sandwich de milanesa (pollo)','lo mismo que de carne pero de pollo','sandwich', 300.00,6);
insert into `producto`(
id_producto,
nombre,
descripcion,
tipo,
precio,
id_negocio
) values
(7,'cono de helado','helado de vainilla','helado', 100.00,7);

insert into `pedido`(id_pedido, direccion, listo, comprador, total, telefono, id_negocio)
values (1, "calle 123", false, "Alguien", 300.00, "12324486", 1);
insert into `pedido`(id_pedido, direccion, listo, comprador, total, telefono, id_negocio)
values (2, "calle 123", false, "Alguien", 300.00, "12324486", 14);
insert into `pedido`(id_pedido, direccion, listo, comprador, total, telefono, id_negocio)
values (3, "calle 123", false, "Alguien", 300.00, "12324486", 12);