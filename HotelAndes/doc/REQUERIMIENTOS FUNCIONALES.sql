--REQUERIMIENTOS FUNCIONALES 
---RF 1 - REGISTRAR ROLES DE USUARIOS 
 
INSERT INTO A_CLIENTE (idCliente, numero, NOMBRE, APELLIDO, CORREO, idMetodoPago, idHotel)  
VALUES (1001, 7841, 'Ruben', 'Sanchez', 'Rubensanchez1991@gmail.com', 3, 1048); 
 
INSERT INTO B_EMPLEADO (idEmpleado, nombre, CELULAR, CORREO)  
VALUES (842, 'Jose', 3248563978 ,'Joseruales83@gmail.com'); 
 
RF2 - REGISTRAR USUARIO 
 
INSERT INTO B_CLIENTE (idCliente, numero, NOMBRE, APELLIDO, CORREO, idMetodoPago, idHotel)  
VALUES (1001, 7841, 'Ruben', 'Sanchez', 'Rubensanchez1991@gmail.com', 3, 1048); 
 
 
 
 
 
 
---RF 3 - REGISTRAR TIPO DE HABITACIÓN 
 
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
 
 
---RF 5 - REGISTRAR SERVICIO DE HOTEL 
 
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
 
---RF 6 - REGISTRAR UN PLAN DE CONSUMO 
 
INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia)  
VALUES (147, 27, '2000000', '31/07/2021'); 
 


----RF 10

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (1, 1000694241, 'Jesus', 'Davila', 'j.davilap@uniandes.edu.co');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (1, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (1, 2, 10,333);

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (50, '17/05/2021','27/07/2021', 8, 1,111,'Activo');


INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (1, 50);


  INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (111, 100000);


INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (201, 50, 111);

   INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 1);

----RF 11

UPDATE A_RESERVA
SET estado ='Activo'
WHERE idReserva=51;

----RF 12

SELECT *
FROM A_HABITACION
WHERE TIPOHABITACION='Suit';


SELECT *
FROM A_SERVICIO_SOLICITADO CC, A_SERVICIO CT 
WHERE CC.idServicio=CT.idServicio ;



----RF 13

UPDATE Per
SET 
Per.Estado='Inactivo',
FROM A_PLANPAGO Per
INNER JOIN
A_HABITACION Addr
ON Per.TIPOHABITACION = Addr.TIPOHABITACION;




