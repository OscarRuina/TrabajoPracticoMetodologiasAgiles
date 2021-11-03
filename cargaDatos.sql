use `db-pedidos`;
    
-- Negocios
insert into `negocio`(id_negocio, nombre, direccion, localidad, telefono) values
(1,'Fabrica de Hamburguesas','Pasteur 453','banfield',1139658495);
insert into `negocio`(id_negocio, nombre, direccion, localidad, telefono) values
(2,'Heladeria Juan Carlos','Rivadavia 1555','banfield',1139601295);

-- Productos de Negocio 1
insert into `producto`(id_producto, nombre, descripcion, tipo, precio, id_negocio) values
(1,'hamburguesa simple','hamburguesa con queso','hamburguesa', 180.50,1);

insert into `producto`(id_producto, nombre, descripcion, tipo, precio, id_negocio) values
(2,'hamburguesa completa','hamburguesa con queso, huevo, lechuga, tomate','hamburguesa', 250.00,1);

insert into `producto`(id_producto, nombre, descripcion, tipo, precio, id_negocio) values
(3,'hamburguesa doble inglesa','hamburguesa con estilo ingles y doble de carne','hamburguesa', 500.00,1);

-- Productos de Negocio 2
insert into `producto`(id_producto, nombre, descripcion, tipo, precio, id_negocio) values
(4,'Helado Simple','helado de vainilla en cono','helado', 150.00,2);

insert into `producto`(id_producto, nombre, descripcion, tipo, precio, id_negocio) values
(5,'Helado de Agua','helado sabor uva de agua','helado', 60.50,2);

-- usuarios contraseña es contra
-- USUARIO 1.........................
-- Manuel
-- Dorrego
-- Arenales 25
-- lanus
-- 1135400045
-- v1
-- contra

-- USUARIO 2.........................
-- Juan Carlos
-- Riviera
-- Sarmiento 102
-- banfield
-- 1135468954
-- v2
-- contra

-- USUARIO 3.........................
-- Yamila
-- Molina
-- Carmona 12
-- banfield
-- 1135469999
-- c
-- contra

-- USUARIO 4.........................
-- Cristian
-- Coria
-- Wilde 152
-- Temperley
-- 1135349854
-- r
-- contra
/*
insert into `user`(user_id, apellido, ciudad, direccion, enabled, nombre, password, telefono, username) values
('1', 'Dorrego', 'lanus', 'Arenales 25', true, 'Manuel', '$2a$07$0mvKPWpBhMg6wWZtCsOGfexeQNOFwo7Nwvwskm/LJuqwoY9LodHMK', '1135400045', 'v1');
insert into `user`(user_id, apellido, ciudad, direccion, enabled, nombre, password, telefono, username) values
('2', 'Riviera', 'banfield', 'Sarmiento 102', true, 'Juan Carlos', '$2a$07$0mvKPWpBhMg6wWZtCsOGfexeQNOFwo7Nwvwskm/LJuqwoY9LodHMK', '1135468954', 'v2');

insert into `user`(user_id, apellido, ciudad, direccion, enabled, nombre, password, telefono, username) values
('3', 'Molina', 'banfield', 'Carmona 12', true, 'Yamila', '$2a$07$0mvKPWpBhMg6wWZtCsOGfexeQNOFwo7Nwvwskm/LJuqwoY9LodHMK', '1135469999', 'c');
insert into `user`(user_id, apellido, ciudad, direccion, enabled, nombre, password, telefono, username) values
('4', 'Coria', 'Temperley', 'Wilde 152', true, 'Cristian', '$2a$07$0mvKPWpBhMg6wWZtCsOGfexeQNOFwo7Nwvwskm/LJuqwoY9LodHMK', '1135349854', 'r');
*/
