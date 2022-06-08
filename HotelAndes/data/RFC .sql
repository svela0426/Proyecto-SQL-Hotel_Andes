--RFC 1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN DURANTE UN PERIODO DE TIEMPO Y EN EL AÑO CORRIDO
SELECT h.NUMEROHABITACION, c.TOTAL
FROM a_habitacion h, a_habitacion_reservada hr, a_cuenta c, a_reserva r
WHERE h.idHabitacion = hr.idHabitacion 
      AND hr.idCuenta = c.idCuenta
      AND r.fechaEntrada >= TO_DATE(?,'YYYY-MM-DD')
      AND r.fechaEntrada < TO_DATE(?,'YYYY-MM-DD')
      AND r.fechaSalida >= TO_DATE(?,'YYYY-MM-DD')
      AND r.fechaSalida < TO_DATE(?,'YYYY-MM-DD')

----------------------------------------------------------

INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (147, 27, '2500000', '31/07/2021');

INSERT INTO B_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (147, 27, '2500000', '31/07/2021');

INSERT INTO C_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (147, 27, '2500000', '31/07/2021');

INSERT INTO D_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (148, 28, '2000000', '31/08/2021');

INSERT INTO E_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (148, 28, '2000000', '31/08/2021');

INSERT INTO F_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (148, 28, '2000000', '31/08/2021');



------RFC 2 - MOSTRAR LOS 20 SERVICIOS MÁS POPULARES

INSERT INTO A_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (51, 'Piscina','Piscina Interna','Recreación');

INSERT INTO B_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (52, 'Piscina','Piscina Terraza','Recreación');

INSERT INTO C_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (53, 'Spa','Spa Interno','Recreación');

INSERT INTO D_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (54, 'Spa','Spa Terraza','Recreación');

INSERT INTO E_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (49, 'Sauna','Sauna grande','Recreación');

INSERT INTO F_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (61, 'Sala de masajes','Sauna grande','Recreación');

INSERT INTO G_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (67, 'Discoteca','Sauna grande','Recreación');

INSERT INTO H_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (68, 'Sala de juegos','Sauna grande','Recreación');

INSERT INTO I_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (69, 'Casino','Sauna grande','Recreación');

INSERT INTO J_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (22, 'Bar','Bar de Whiskeys','Bares'); 

INSERT INTO K_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (28, 'Bar','Bar de la Terraza norte','Bares');

INSERT INTO L_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (29, 'Bar','Bar de la Terraza sur','Bares');

INSERT INTO M_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (11, 'Restaurante','Heladeria','Restaurantes');

INSERT INTO N_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (17, 'Restaurante','Hamburgueseria','Restaurantes');

INSERT INTO O_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (14, 'Restaurante Desayunos','BBQ','Restaurantes');

INSERT INTO P_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (15, 'Restaurante Almuerzos','BBQ','Restaurantes');

INSERT INTO Q_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (16, 'Restaurante','Sandwicheria','Restaurantes');

INSERT INTO R_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (12, 'Restaurante','Pasteleria','Restaurantes');

INSERT INTO S_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (18, 'Restaurante','BBQ','Restaurantes');

INSERT INTO T_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (19, 'Restaurante','Elegante','Restaurantes');




--RFC3 - MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL



INSERT INTO B_REGISTRO_OCUPACION_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado) 
VALUES (1003, 'Habitacion Especial',1,1,703,842);

INSERT INTO B_REGISTRO_OCUPACION_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado) 
VALUES (1023, 'Habitacion Doble',2,2,723,851);

INSERT INTO B_REGISTRO_OCUPACION_HABITACION (idHabitacion, nombre, CAPACIDAD, tipoHabitacion, numeroHabitacion, idEmpleado) 
VALUES (1025, 'Habitacion Familiar',3,3,725,853);


--RFC4 - MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA

INSERT INTO M_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (11, 'Restaurante','Heladeria','Restaurantes');

INSERT INTO R_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (12, 'Restaurante','Pasteleria','Restaurantes');

INSERT INTO O_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (14, 'Restaurante Desayunos','BBQ','Restaurantes');

INSERT INTO P_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (15, 'Restaurante Almuerzos','BBQ','Restaurantes');

INSERT INTO Q_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (16, 'Restaurante','Sandwicheria','Restaurantes');

INSERT INTO N_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (17, 'Restaurante','Hamburgueseria','Restaurantes');

INSERT INTO S_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (18, 'Restaurante','BBQ','Restaurantes');

INSERT INTO T_SERVICIO (idServicio, nombre, DESCRIPCION, area)
VALUES (19, 'Restaurante','Elegante','Restaurantes');





--RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO

INSERT INTO B_CLIENTE (idCliente, numero, NOMBRE, APELLIDO, CORREO, idMetodoPago, idHotel) 
VALUES (1001, 7841, 'Ruben', 'Sanchez', 'Rubensanchez1991@gmail.com', 3, 1048);

INSERT INTO A_PLAN_CONSUMO (idPlanConsumo, nombre, costo, vigencia) 
VALUES (147, 27, '2000000', '31/07/2021');