REQUERIMIENTOS FUNCIONALES 
RF 1 - REGISTRAR ROLES DE USUARIOS 
 
INSERT INTO A_CLIENTE (idCliente, numero, NOMBRE, APELLIDO, CORREO, idMetodoPago, idHotel)  
VALUES (1001, 7841, 'Ruben', 'Sanchez', 'Rubensanchez1991@gmail.com', 3, 1048); 
 
INSERT INTO B_EMPLEADO (idEmpleado, nombre, CELULAR, CORREO)  
VALUES (842, 'Jose', 3248563978 ,'Joseruales83@gmail.com'); 
 
RF2 - REGISTRAR USUARIO 
 
INSERT INTO B_CLIENTE (idCliente, numero, NOMBRE, APELLIDO, CORREO, idMetodoPago, idHotel)  
VALUES (1001, 7841, 'Ruben', 'Sanchez', 'Rubensanchez1991@gmail.com', 3, 1048); 
 
 
 
 
 
 
RF 3 - REGISTRAR TIPO DE HABITACIÓN 
 
INSERT A_REGISTRO_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA) 
VALUES ('Sencilla ', 1, 20); 
 
INSERT B_REGISTRO_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA) 
VALUES ('Doble', 2, 30); 
 
 
INSERT C_REGISTRO_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA) 
VALUES ('Familiar', 4, 50); 
 
RF 4 - REGISTRAR HABITACIÓN 
 
INSERT INTO A_REGISTRO_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado)  
VALUES (1001, 'Habitacion Especial',1,1,703,842); 
 
INSERT INTO B_REGISTRO_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado)  
VALUES (1002, 'Habitacion Estandar',1,3,417,741); 
 
 
INSERT INTO C_REGISTRO_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado)  
VALUES (1003, 'Habitacion Economica',1,5,205,645); 
 
 
RF 5 - REGISTRAR SERVICIO DE HOTEL 
 
INSERT INTO A_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (52, 'Piscina','Piscina Terraza','Recreación'); 
 
INSERT INTO B_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (11, 'Restaurante','Heladeria','Restaurantes'); 
 
INSERT INTO C_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (17, 'Restaurante','Hamburgueseria','Restaurantes'); 
 
INSERT INTO D_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (18, 'Restaurante','BBQ','Restaurantes'); 
 
INSERT INTO G_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (22, 'Bar','Bar de Whiskeys','Bares'); 
 
INSERT INTO E_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (28, 'Bar','Bar de la Terraza norte','Bares'); 
 
INSERT INTO F_SERVICIO (idServicio, nombre, DESCRIPCION, area) 
VALUES (29, 'Bar','Bar de la Terraza sur','Bares'); 
 
RF 6 - REGISTRAR UN PLAN DE CONSUMO 
 
INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia)  
VALUES (147, 27, '2000000', '31/07/2021'); 
 
