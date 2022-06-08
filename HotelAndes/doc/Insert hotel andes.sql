INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (10, 'Hotel AAA','Bogota','www.hotelandes.com.co', 300100200);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (20, 'Hotel BBB','Medellin','www.hotelandes.com.co', 300200300);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (30, 'Hotel CCC','Medellin','www.hotelandes.com.co', 300300400);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (40, 'Hotel DDD','Bogota','www.hotelandes.com.co', 3004005000);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (50, 'Hotel EEE','Medellin','www.hotelandes.com.co', 3005006000);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (60, 'Hotel FFF','Bogota','www.hotelandes.com.co', 3006007000);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (70, 'Hotel GGG','Bogota','www.hotelandes.com.co', 3007008000);

INSERT INTO A_HOTEL (idHotel, nombre, ubicacion, paginaweb, NUMERO) 
VALUES (80, 'Hotel HHH','Medellin','www.hotelandes.com.co', 3008009000);


---- bien--------





INSERT INTO A_SERVICIO (idServicio, nombre, descripcion, area)
VALUES (1, 'Sauna','area de esparcimiento social a temparatura altas',30);


INSERT INTO A_SERVICIO (idServicio, nombre, descripcion, area)
VALUES (2, 'piscina',' Construcción o recipiente de grandes dimensiones para bañarse, nadar o practicar deportes acuáticos',90);


INSERT INTO A_SERVICIO (idServicio, nombre, descripcion, area)
VALUES (3, 'cancha futbol','Espacio de zona verde de gran eapacio para 22 personas',120);



INSERT INTO A_SERVICIO (idServicio, nombre, descripcion, area)
VALUES (4, 'salon','area dedicada para hacer eventos o reuniones',70);


INSERT INTO A_SERVICIO (idServicio, nombre, descripcion, area)
VALUES (5, 'golf',' deporte de gran magnitud que se juega de 6 am a 4 am ',500);


---- bien-----




INSERT INTO A_SERVICIO_SOLICITADO (idServicio, numpersonas, Costo,fecha_solicitud)
VALUES (1, 10, 60.000,'31/01/2022');

INSERT INTO A_SERVICIO_SOLICITADO (idServicio, numpersonas, Costo,fecha_solicitud)
VALUES (2, 50, 40.000,'03/02/2022');


INSERT INTO A_SERVICIO_SOLICITADO (idServicio, numpersonas, Costo,fecha_solicitud)
VALUES (3, 22, 10.000,'31/03/2022');


INSERT INTO A_SERVICIO_SOLICITADO (idServicio, numpersonas, Costo,fecha_solicitud)
VALUES (4, 60, 10.000,'22/04/2022');


INSERT INTO A_SERVICIO_SOLICITADO (idServicio, numpersonas, Costo,fecha_solicitud)
VALUES (5, 20, 90.000,'13/09/2022');


---- bien-----



----------------BIEN-------------
INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 10);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 10);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 10);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 10);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 10);


INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 20);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 20);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 20);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 20);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 20);



INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 30);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 30);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 30);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 30);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 30);



INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 40);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 40);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 40);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 40);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 40);



INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 50);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 50);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 50);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 50);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 50);



INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 60);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 60);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 60);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 60);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 60);


INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 70);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 70);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 70);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 70);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 70);



INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (1, 80);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (2, 80);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (3, 80);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (4, 80);

INSERT INTO A_SERVICIO_OFRECIDO (idServicio, idHotel)
VALUES (5, 80);


----------------BIEN-------------


------bien--------
INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (101, 'PLATINO', '10000000', '13/02/2021');


INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (102, 'ORO', '8000000', '31/03/2021');


INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (103, 'RUBI', '5000000', '20/04/2021');


INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (104, 'ESMERALDA', '4000000', '31/05/2021');


INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (105, 'DIAMANTE', '2000000', '31/01/2022');
------bien--------




------bien--------

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 10);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 10);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 10);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 10);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 10);


INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 20);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 20);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 20);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 20);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 20);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 30);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 30);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 30);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 30);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 30);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 40);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 40);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 40);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 40);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 40);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 50);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 50);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 50);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 50);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 50);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 60);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 60);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 60);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 60);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 60);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 70);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 70);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 70);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 70);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 70);

INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (101, 80);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (102, 80);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (103, 80);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (104, 80);
INSERT INTO A_PLAN_OFRECIDO (idPlanConsumo, idHotel)
VALUES (105, 80);

------bien--------


-------BIEN-------
INSERT INTO A_METODO_PAGO (idMetodo, tipo, nombre)
VALUES (1, 'Digital', 'Daviplata');

INSERT INTO A_METODO_PAGO (idMetodo, tipo, nombre)
VALUES (2, 'Digital', 'Nequi');

INSERT INTO A_METODO_PAGO (idMetodo, tipo, nombre)
VALUES (3, 'Fisico', 'Efectivo');
-------BIEN-------



-------BIEN-------
INSERT INTO A_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA)
VALUES ('Sencilla', 10, 90);
INSERT INTO A_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA)
VALUES ('Suit', 15, 80);
INSERT INTO A_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA)
VALUES ('presidencial', 5, 30);
INSERT INTO A_TIPO_HABITACION (tipoHabitacion, CAPACIDAD, AREA)
VALUES ('doble', 2, 20);

-------BIEN-------

-------BIEN-------


INSERT INTO A_PLANPAGO(id,tipoHabitacion,numeroHabitaciones,numero_peronas,fecha_inicio,fecha_final,estado)
VALUES(111,'Suit',10,30,'10/02/2021','20/02/2021','Activo');

INSERT INTO A_PLANPAGO(id,tipoHabitacion,numeroHabitaciones,numero_peronas,fecha_inicio,fecha_final,estado)
VALUES(222,'doble',20,60,'25/07/2021','15/06/2021','Inactivo');

INSERT INTO A_PLANPAGO(id,tipoHabitacion,numeroHabitaciones,numero_peronas,fecha_inicio,fecha_final,estado)
VALUES(333,'Sencilla',10,20,'13/09/2021','23/09/2021','Pasada');

-------BIEN-------








-------BIEN-------

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (1, 1000694241, 'Jesus', 'Davila', 'j.davilap@uniandes.edu.co');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (1, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (1, 2, 10,333);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (2, 1000696571, 'Pedro', 'Rodriguez', 'prOdriguez18@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (2, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente)
VALUES (2, 3, 10);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (3, 1017696571, 'Alejandra', 'Gomez', 'unuAl@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (3, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (3, 1, 20,111);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (4, 1017696571, 'Alejandra', 'Gomez', 'unuAl@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (4, 'Cliente');

INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente)
VALUES (4, 1, 10);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (5, 1103694252, 'Oscar', 'Barrera', 'n11ger66@hotmail.co');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (5, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (5, 1, 20,222);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (6, 1076606571, 'Camilo', 'Cardenas', 'cc338@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (6, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente)
VALUES (6, 1, 10);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (7, 1017006531, 'German', 'Rojas', 'gerRojo13@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (7, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (7, 3, 10,111);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (8, 2017887571, 'Ivan', 'Cardenas', 'iCar22@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (8, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (8, 1, 10,222);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (9, 1017631071, 'Raul', 'Draven', 'leagueOfDraven@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (9, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente)
VALUES (9, 1, 20);

INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (10, 100000071, 'Caren', 'Jimenez', 'pato399@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (10, 'Cliente');
    
INSERT INTO A_CLIENTE (id, metodoPago, hotelPerteneciente,idPlanPago)
VALUES (10, 3, 10,333);



-------BIEN-------







-------BIEN-------

---- Usuarios 20, 1-20, clientes: 10 ,1..10- empleado:  5 11...15,organizador eventos 2  16-17, administradores 2, gerente 1

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (201, 'feliz lugar','Suit',2010,1);


INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (202, 'buen lugar','presidencial',2011,2);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (203, 'enorme lugar','sencilla',2012,3);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (204, 'genial lugar','doble',2013,4);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (205, 'espectacular lugar','Suit',2014,5);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (206, 'normal lugar','presidencial',2015,6);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (207, 'sencillo lugar','sencilla',2016,7);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (208, 'aceptable lugar','doble',2017,8);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (209, 'fresco lugar','Suit',2018,9);

INSERT INTO A_HABITACION (idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idUsuario) 
VALUES (210, 'tranquilo lugar','presidencial',2019,10);

-------BIEN-------












-------BIEN-------
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (10, 201);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (20, 202);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (30, 203);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (40, 204);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (50, 205);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (60, 206);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (70, 207);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (80, 208);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (80, 209);
INSERT INTO A_HABITACION_OFERTADA (idHotel, idHabitacion) 
VALUES (10, 210);

-------BIEN-------












-------BIEN-------



INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (50, '17/05/2021','27/07/2021', 8, 1,111,'Activo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,estado)
VALUES (51, '11/02/2022','21/02/2021', 5, 2,'Inactivo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (52, '12/07/2021','22/07/2021', 8, 3,111,'Activo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,estado)
VALUES (53, '17/07/2022','30/07/2022', 5, 4,'Inactivo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (54, '18/07/2021','20/07/2021', 8, 5,111,'Activo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (55, '13/09/2022','30/09/2022', 5, 6,333,'Inactivo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (56, '17/10/2021','30/10/2021', 8, 7,111,'Activo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (57, '17/12/2022','30/12/2022', 5, 8,333,'Inactivo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (58, '17/11/2022','30/11/2022', 8, 9,111,'Activo');

INSERT INTO A_RESERVA (idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado)
VALUES (59, '17/03/2022','30/03/2022', 5, 10,222,'Inactivo');
-------BIEN-------


-------BIEN-------
INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (50, 101);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (51, 103);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (52, 101);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (53, 104);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (54, 105);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (55, 101);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (56, 103);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (57, 101);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (58, 102);

INSERT INTO A_TIPO_RESERVA (idReserva, idPlanConsumo)
VALUES (59, 105);
-------BIEN-------




-------BIEN-------
INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (1, 50);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (2, 51);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (3, 52);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (4, 53);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (5, 54);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (6, 55);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (7, 56);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (8, 57);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (9, 58);

INSERT INTO A_CLIENTE_ACTIVO (idCliente, idReserva) 
VALUES (10, 59);
-------BIEN-------


-------BIEN-------
--Inserción de empleado activo (id 11 al 15)
    INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
    VALUES (11, 1002346571, 'Anna', 'Perez', 'anPe8@gmail.com');

    INSERT INTO A_ROlUSUARIO (id_usuario, rol)
    VALUES (11, 'Empleado');

    INSERT INTO A_EMPLEADO_ACTIVO (idHotel, idEmpleado)
    VALUES (10, 11);
    -------------------------------------------------------------------------
    INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
    VALUES (12, 1002399671, 'falcao', 'garcia', 'anPe89@gmail.com');

    INSERT INTO A_ROlUSUARIO (id_usuario, rol)
    VALUES (12, 'Empleado');

    INSERT INTO A_EMPLEADO_ACTIVO (idHotel, idEmpleado)
    VALUES (20, 12);
    -------------------------------------------------------------------------
    INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
    VALUES (13, 10023333445, 'james', 'hernandez', 'anPe89@gmail.com');

    INSERT INTO A_ROlUSUARIO (id_usuario, rol)
    VALUES (13, 'Empleado');

    INSERT INTO A_EMPLEADO_ACTIVO (idHotel, idEmpleado)
    VALUES (30, 13);
    -------------------------------------------------------------------------
    INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
    VALUES (14, 10023333445, 'rodrigo', 'cantor', 'anPe89@gmail.com');

    INSERT INTO A_ROlUSUARIO (id_usuario, rol)
    VALUES (14, 'Empleado');

    INSERT INTO A_EMPLEADO_ACTIVO (idHotel, idEmpleado)
    VALUES (40, 14);
    -------------------------------------------------------------------------
    INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)        
    VALUES (15, 10023333445, 'felipe', 'augusto', 'anPe89@gmail.com');

    INSERT INTO A_ROlUSUARIO (id_usuario, rol)
    VALUES (15, 'Empleado');

    INSERT INTO A_EMPLEADO_ACTIVO (idHotel, idEmpleado)
    VALUES (50, 15);
-------BIEN-------









-----------------BIEN-----------------------------
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (111, 100000);

    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (112, 300000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (113, 5000000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (114, 600000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (115, 6700000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (116, 2000000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (117, 9000000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (118, 700000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (119, 12000000);
    INSERT INTO A_CUENTA (idCuenta, total)
    VALUES (120, 9000000);

 -----------------------BIEN----------------------




-----------BIEN--------------
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (111, 5);



    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (112, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (112, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (112, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (112, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (112, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (113, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (113, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (113, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (113, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (113, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (114, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (114, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (114, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (114, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (114, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (115, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (115, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (115, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (115, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (115, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (116, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (116, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (116, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (116, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (116, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (117, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (117, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (117, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (117, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (117, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (118, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (118, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (118, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (118, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (118, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (119, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (119, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (119, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (119, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (119, 5);

    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (120, 1);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (120, 2);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (120, 3);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (120, 4);
    INSERT INTO A_CUENTA_CARGADA (idCuenta, idServicio) 
    VALUES (120, 5);

-----------BIEN--------------

-----------BIEN--------------
INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (201, 50, 111);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (202, 51, 112);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (203, 52, 113);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (204, 53, 114);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (205, 54, 115);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (206, 56, 116);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (208, 57, 117);

INSERT INTO A_HABITACION_RESERVADA (idHabitacion, idReserva, idCuenta) 
VALUES (207, 58, 118);
-----------BIEN--------------







-----------BIEN--------------
INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (16, 11000222333, 'Lokillo', 'gomes', 'lok345@gmail.com');

INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (16, 'Organizador Eventos');
INSERT INTO A_ORGANIZADOREVENTOS (id_Organizador, plande_Pago)
VALUES (16, 111);


INSERT INTO A_USUARIO (id, numero, NOMBRE, APELLIDO, CORREO)
VALUES (17, 5555555666788, 'pirata', 'morgan', 'pirt56@gmail.com');
INSERT INTO A_ROlUSUARIO (id_usuario, rol)
VALUES (17, 'Organizador Eventos');
INSERT INTO A_ORGANIZADOREVENTOS (id_Organizador, plande_Pago)
VALUES (17, 333);
-----------BIEN--------------



-----------BIEN--------------
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 111, 1,30,1000000);
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 111, 2,30,45000000);

INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 111, 3,30,67000000);
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 111, 4,40,20000000);


INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 333, 1,40,540000000);
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 333, 2,40,2003430000);
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 333, 3,40,2000054000);
INSERT INTO A_CONSUMOSCONVENCION(id,servicio_solicitado,capacidad,total)
VALUES( 333, 4,40,222340000);
-----------BIEN--------------


















-----------------------------------------





