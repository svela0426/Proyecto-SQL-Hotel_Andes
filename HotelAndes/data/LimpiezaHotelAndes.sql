DROP TABLE A_HOTEL CASCADE CONSTRAINTS;
DROP TABLE A_USUARIO  CASCADE CONSTRAINTS;
DROP TABLE A_HABITACION CASCADE CONSTRAINTS;
DROP TABLE A_HABITACION_OFERTADA CASCADE CONSTRAINTS;
DROP TABLE A_HABITACION_RESERVADA CASCADE CONSTRAINTS;
DROP TABLE A_SERVICIO_OFRECIDO CASCADE CONSTRAINTS;
DROP TABLE A_RESERVA CASCADE CONSTRAINTS;
DROP TABLE A_SERVICIO CASCADE CONSTRAINTS;
DROP TABLE A_SERVICIO_SOLICITADO CASCADE CONSTRAINTS;
DROP TABLE A_TIPO_HABITACION CASCADE CONSTRAINTS;
DROP TABLE A_TIPO_RESERVA CASCADE CONSTRAINTS;
DROP TABLE A_METODO_PAGO CASCADE CONSTRAINTS;
DROP TABLE A_CLIENTE CASCADE CONSTRAINTS;
DROP TABLE A_CLIENTE_ACTIVO CASCADE CONSTRAINTS;
DROP TABLE A_CUENTA CASCADE CONSTRAINTS;
DROP TABLE A_EMPLEADO_ACTIVO CASCADE CONSTRAINTS;
DROP TABLE A_CUENTA_CARGADA CASCADE CONSTRAINTS;
DROP TABLE A_PLAN_CONSUMO CASCADE CONSTRAINTS;
DROP TABLE A_PLAN_OFRECIDO CASCADE CONSTRAINTS;
DROP TABLE A_ORGANIZADOREVENTOS CASCADE CONSTRAINTS;
DROP TABLE A_CONSUMOSCONVENCION CASCADE CONSTRAINTS;
DROP TABLE A_PLANPAGO CASCADE CONSTRAINTS;
DROP TABLE A_ROlUSUARIO CASCADE CONSTRAINTS;

COMMMIT;


delete from A_HOTEL;
delete from A_HABITACION;
delete from A_HABITACION_OFERTADA;
delete from A_HABITACION_RESERVADA;
delete from A_SERVICIO_OFRECIDO;
delete from A_RESERVA;
delete from A_SERVICIO;
delete from A_SERVICIO_SOLICITADO;
delete from A_TIPO_HABITACION;
delete from A_TIPO_RESERVA;
delete from A_METODO_PAGO;
delete from A_CLIENTE;
delete from A_CLIENTE_ACTIVO;
delete from A_CUENTA;
delete from A_EMPLEADO;
delete from A_EMPLEADO_ACTIVO;
delete from A_CUENTA_CARGADA;
delete from A_PLAN_CONSUMO;
delete from A_PLAN_OFRECIDO;
commit;