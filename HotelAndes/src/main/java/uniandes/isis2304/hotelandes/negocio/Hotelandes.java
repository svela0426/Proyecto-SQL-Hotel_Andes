package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;



public class Hotelandes
{
	
	private static Logger log = Logger.getLogger(Hotelandes.class.getName());
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	
	
	public Hotelandes ()
	{
		
		
		pp = PersistenciaHotelAndes.getInstance ();

	}
	
	
	public Hotelandes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}
	
	
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los consumo de convenciones
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un CLIENTE
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */
	
	public ConsumoConvencion adicionarConsumoConvencion(String servicioSolicitado, int capacidad,int precio) 
	{
		log.info ("Adicionando Usuario: " + servicioSolicitado);
		ConsumoConvencion cliente = pp.adicionarConsumoConvencion (servicioSolicitado,  capacidad,precio);
	        log.info ("Adicionando Usuario: " + cliente);
	        return cliente;		
	}
	
	public long eliminarConsumoConvencionporPlandePago (long idPlandePago)
	{
		log.info ("Eliminando ConsumoConvencion por PlandePago: " + idPlandePago);
        long resp = pp.eliminarConsumoConvencionporPlandePago (idPlandePago);
        log.info ("Eliminando ConsumoConvencion por PlandePago: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	
	public long eliminarConsumoConvencionporServicioSolicitado ( String servicioSolicitado)
	{	
		log.info ("Eliminando ConsumoConvencion por servicio: " + servicioSolicitado);
        long resp = pp.eliminarConsumoConvencionporServicioSolicitado (servicioSolicitado);
        log.info ("Eliminando ConsumoConvencion por servicio: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	public ConsumoConvencion darConsumoConvencionporServicioPorPlandePago (long idPlandePago)
	{
		
		log.info ("Dar información de un ConsumoConvencion por id: " + idPlandePago);
		ConsumoConvencion cliente = pp.darConsumoConvencionporServicioPorPlandePago (idPlandePago);
        log.info ("Buscando ConsumoConvencion por Id: " + cliente != null ? cliente : "NO EXISTE");
        return cliente;
	}
	
	
	public List<ConsumoConvencion> darConsumoConvencionPorservicio ( String servicioSolicitado) 
	{
		log.info ("Dar información de usuario por numero: " + servicioSolicitado);
	     List<ConsumoConvencion> cliente = pp.darConsumoConvencionPorservicio (servicioSolicitado);
	     log.info ("Dar información de usuario por numero: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;
		
	}
	
	public List<ConsumoConvencion> darConsumoConvenciones ( ) 
	{
		
		log.info ("Dar información de ConsumoConvenciones: " );
	     List<ConsumoConvencion> cliente = pp.darConsumoConvenciones ();
	     log.info ("Listando Usuarios: " + cliente.size() + " Usuarios existentes");
	       return cliente;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los Usuario
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un CLIENTE
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */
	
	
	public Usuario adicionarUsuario(BigDecimal numero, String nombre, String apellido, String correo) 
	{
		log.info ("Adicionando Usuario: " + nombre);
		Usuario cliente = pp.adicionarUsuario (numero,  nombre,  apellido,  correo);
        log.info ("Adicionando Usuario: " + cliente);
        return cliente;	
	}
	
	public long eliminarUsuarioPorId(long idUsuario) 
	{
		log.info ("Eliminando Usuario por ID: " + idUsuario);
        long resp = pp.eliminarUsuarioPorId (idUsuario);
        log.info ("Eliminando Usuario por ID: " + resp + " tuplas eliminadas");
        return resp;
		
		
	}
	
	public long eliminarUsuarioPorNombre (String nombre)
	{
		log.info ("Eliminando Usuario por Nombre: " + nombre);
        long resp = pp.eliminarUsuarioPorNombre (nombre);
        log.info ("Eliminando Usuario por Nombre: " + resp + " tuplas eliminadas");
        return resp;
		
		
	}
	
	
	public Usuario darUsuarioPorId (long idCliente)
	{
        log.info ("Dar información de un usuario por id: " + idCliente);
        Usuario cliente = pp.darUsuarioPorId (idCliente);
        log.info ("Buscando usuario por Id: " + cliente != null ? cliente : "NO EXISTE");
        return cliente;
	}
	
	
	public List<Usuario> darUsuarioPorNumero (long numero)
	{
        log.info ("Dar información de usuario por numero: " + numero);
        List<Usuario> cliente = pp.darUsuarioPorNumero (numero);
        log.info ("Dar información de usuario por numero: " + cliente.size() + " Clientes con ese numero existentes");
        return cliente;
 	}
	
	
	public List<Usuario> darUsuarioPorNombre(String nombre) {
		
		 log.info ("Dar información de usuario por numero: " + nombre);
	     List<Usuario> cliente = pp.darUsuarioPorNombre (nombre);
	     log.info ("Dar información de usuario por numero: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;
	}
	
	
	public  List<VOUsuario>  darVOUsuariosPorNombre (String nombre)
	{
        log.info ("Generando VO de usuarios por nombre: " + nombre);
        List<VOUsuario> voCliente = new LinkedList<VOUsuario> ();
        
       for (Usuario bdor : pp.darUsuarioPorNombre (nombre))
       {
    	   voCliente.add (bdor);
       }
       log.info ("Generando los VO de los usuarios: " + voCliente.size() + " Clientes existentes");
      return voCliente;
 	}
	
	public List<Usuario> darUsuarios ()
	{
        log.info ("Listando Usuarios");
        List<Usuario> clientes = pp.darUsuarios ();	
        log.info ("Listando Usuarios: " + clientes.size() + " Usuarios existentes");
        return clientes;
	}
	
	
	public List<VOUsuario> darVOUsuarios ()
	{
        log.info ("Generando los VO de usuarios");
         List<VOUsuario> voCliente = new LinkedList<VOUsuario> ();
        for (Usuario bdor : pp.darUsuarios ())
        {
        	voCliente.add (bdor);
        }
       return voCliente;
	}
	
	
	public List<Usuario> darUsuarioPorApellido(String apellido) {
		
		 log.info ("Dar información de usuarios por apellido: " + apellido);
	     List<Usuario> cliente = pp.darUsuarioPorApellido (apellido);
	     log.info ("Dar información de usuarios por apellido: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;
		
		
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los Cliente 
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un CLIENTE  Activo
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */
	
	
	public Cliente adicionarCliente(BigDecimal idMetodoPago, BigDecimal idHotel,BigDecimal plandepago) 
	{
		log.info ("Adicionando cliente en el hotel: "+idHotel);
		Cliente cliente = pp.adicionarCliente (idMetodoPago, idHotel, plandepago);
        log.info ("Adicionando Cliente: " + cliente);
        return cliente;
	}
	
	public long eliminarClientePorId (long idUsuario)
	{
		log.info ("Eliminando Usuario por ID: " + idUsuario);
        long resp = pp.eliminarClientePorId (idUsuario);
        log.info ("Eliminando Usuario por ID: " + resp + " tuplas eliminadas");
        return resp;			
	}
	
	public long eliminarClientePorMetodoPago ( long idMetodoPago)
	{
		log.info ("ClientePorMetodoPago: " + idMetodoPago);
        long resp = pp.eliminarClientePorMetodoPago (idMetodoPago);
        log.info ("ClientePorMetodoPago: " + resp + " tuplas eliminadas");
        return resp;	
	}
	
	public long eliminarClientePorHotel ( long idHotel)
	{	
		log.info ("ClientePorHotel : " + idHotel);
        long resp = pp.eliminarClientePorHotel (idHotel);
        log.info ("ClientePorHotel : " + resp + " tuplas eliminadas");
        return resp;			
	}	
	
	
	public long eliminarEmpleadoporPlandepago ( long plandepago)
	{
		log.info ("eliminarEmpleadoporPlandepago: " + plandepago);
        long resp = pp.eliminarEmpleadoporPlandepago (plandepago);
        log.info ("eliminarEmpleadoporPlandepago: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	
	public List<Cliente> darClientes() {
		
		log.info ("Listando Usuarios");
        List<Cliente> clientes = pp.darClientes ();	
        log.info ("Listando Usuarios: " + clientes.size() + " Usuarios existentes");
        return clientes;

	}
	
	public Cliente darClientePorId(long idCliente) {
		
		log.info ("Dar información de un Cliente por id: " + idCliente);
		Cliente cliente = pp.darClientePorId (idCliente);
        log.info ("Buscando Cliente por Id: " + cliente != null ? cliente : "NO EXISTE");
        return cliente;
		
	}
	
	public List<Cliente> darClientePorMetodoPago ( long idMetodoPago) 
	{
		 log.info ("Dar información de Clientes por rMetodoPagos: " + idMetodoPago);
	     List<Cliente> cliente = pp.darClientePorMetodoPago (idMetodoPago);
	     log.info ("Dar información de Clientes por apellido: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;	
	}
	
	public List<Cliente> darClientePorHotel ( long idHotel) {
		
		log.info ("Dar información de Clientes por ePorHotel: " + idHotel);
	     List<Cliente> cliente = pp.darClientePorHotel (idHotel);
	     log.info ("Dar información de Clientes por apellido: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;	
		
	}
	
	
	public List<Cliente> darClienteporPlandepago ( BigDecimal plandepago) 
	{
		
		log.info ("Dar información de Clientes por Plandepago: " + plandepago);
	     List<Cliente> cliente = pp.darClienteporPlandepago (plandepago);
	     log.info ("Dar información de Clientes por Plandepago: " + cliente.size() + " Clientes con ese numero existentes");
	     return cliente;	
		
	}


	
	
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los Cliente Activo
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un CLIENTE  Activo
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */
	
	
	
	public ClienteActivo adicionarClienteActivo(BigDecimal idCliente, BigDecimal idReserva) {
		
		
		log.info ("Adicionando Cliente Activo: " + idCliente);
		ClienteActivo clienteActivo = pp.adicionarClienteActivo (idCliente, idReserva);
        log.info ("Adicionando Cliente Activo: " + idCliente);
        return clienteActivo;
	}
	
	
	
	public long eliminarClienteActivo(BigDecimal idCliente, BigDecimal idReserva) 
	{
		log.info ("Eliminando Cliente Activo");
        long resp = pp.eliminarClienteActivo (idCliente, idReserva);
        log.info ("Eliminando Cliente Activo: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	public ClienteActivo darClienteActivoPorId(BigDecimal idCliente) 
	{
		log.info ("Buscando Cliente Activo");
        ClienteActivo resp = pp.darClienteActivoPorId(idCliente);
        log.info ("Encontrado Cliente Activo: " + resp);
        return resp;
	}

	 public List<ClienteActivo> darClienteActivo() {
		 
		 log.info ("Listando ClienteActivo");
	        List<ClienteActivo> clienteActivo = pp.darClienteActivo ();	
	        log.info ("Listando Gustan: " + clienteActivo.size() + " preferencias de gusto existentes");
	        return clienteActivo;
	 }
	 
	 
	 public List<VOClienteActivo> darVOClienteActivo ()
		{
			log.info ("Generando los VO de Gustan");
			List<VOClienteActivo> voClienteActivo = new LinkedList<VOClienteActivo> ();
			for (VOClienteActivo bar: pp.darClienteActivo ())
			{
				voClienteActivo.add (bar);
			}
			log.info ("Generando los VO de Gustan: " + voClienteActivo.size () + " Gustan existentes");
			return voClienteActivo;
		}

	 
	 
	 /* ****************************************************************
		 * 			Métodos para manejar los CUENTA
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un CUENTA  
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 
	 
	 
	 
	 
	 public Cuenta adicionarCuenta(BigDecimal total) 
	    {
		 

		log.info ("Adicionando Cuenta: " + total);
		Cuenta cuenta = pp.adicionarCuenta (total );
		log.info ("Adicionando Cuenta: " + total);
		return cuenta;	
	 
	    }
	 
	 
	 
	 public long eliminarCuentaPorId (long idCuenta)
		{
		 
		 log.info ("Eliminando Cuenta por id: " + idCuenta);
	        long resp = pp.eliminarCuentaPorId (idCuenta);
	        log.info ("Eliminando Cuenta: " + resp);
	        return resp;
		 
		 
		}
	 
	 
	 public  List<Cuenta> darCuentas ()
		{
		 
		 log.info ("Listando Bares");
	        List<Cuenta> cuentas = pp.darCuentas ();	
	        log.info ("Listando Bares: " + cuentas.size() + " bares existentes");
	        return cuentas;
		 
		 
		}
	 
	 
	 
	 public List<VOCuenta> darVOBares ()
		{
			log.info ("Generando los VO de Bares");
			List<VOCuenta> voCuenta = new LinkedList<VOCuenta> ();
			for (Cuenta bar: pp.darCuentas ())
			{
				voCuenta.add (bar);
			}
			log.info ("Generando los VO de Cuentas: " + voCuenta.size () + " Cuentas existentes");
			return voCuenta;
		}
	 
	 
	 

	 /* ****************************************************************
		 * 			Métodos para manejar los CUENTA CARGADA
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un CUENTA    CARGADA
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 
	 
	 
	 
	 public CuentaCargada adicionarCuentaCargada(long idCuenta, long idServicio) {
		 
		 log.info ("Adicionando Cuenta Cargada [" + idCuenta + ", " + idServicio + "]");
		 CuentaCargada resp = pp.adicionarCuentaCargada (idCuenta, idServicio);
	        log.info ("Adicionando Cuenta Cargada : " + resp + " tuplas insertadas");
	        return resp;
	 }
	 
	 
	 public long eliminarCuentaCargada(long idCuenta, long idServicio) 
		{
		 log.info ("Eliminando Cuenta Cargada");
	        long resp = pp.eliminarCuentaCargada (idCuenta, idServicio);
	        log.info ("Eliminando  Cuenta Cargada: " + resp + " tuplas eliminadas");
	        return resp;
		}
	 
	 
	 public List<CuentaCargada> darCuentaCargada ( )
		{
		 
		 log.info ("Listando Cuenta Cargada");
	        List<CuentaCargada> cuentaCargada = pp.darCuentaCargada ();	
	        log.info ("Listando Cuenta Cargada: " + cuentaCargada.size() + " preferencias de gusto existentes");
	        return cuentaCargada;
	        }
	 
	 
	 public List<VOCuentaCargada> darVOCuentaCargada ()
		{
			log.info ("Generando los VO de Cuenta Cargada");
			List<VOCuentaCargada> voCuentaCargada = new LinkedList<VOCuentaCargada> ();
			for (VOCuentaCargada bar: pp.darCuentaCargada ())
			{
				voCuentaCargada.add (bar);
			}
			log.info ("Generando los VO de Gustan: " + voCuentaCargada.size () + " Gustan existentes");
			return voCuentaCargada;
		}
	 
	 
	 
	 /* ****************************************************************
		 * 			Métodos para manejar los EMPLEADO
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un EMPLEADO
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 
	 
	 
	 
	 
	 public Empleado adicionarEmpleado(String nombre, long celular, String correo) {
		 
		 log.info ("Adicionando Empleado: " + nombre);
		 Empleado empleado = pp.adicionarEmpleado (nombre, celular, correo);
	        log.info ("Adicionando Empleado: " + empleado);
	        return empleado;
	        }
	 
	 
	 public long eliminarEmpleadoPorId (long idEmpleado)
		{
		 log.info ("Eliminando Empleado por Id: " + idEmpleado);
	        long resp = pp.eliminarEmpleadoPorId (idEmpleado);
	        log.info ("Eliminando Empleado: " + resp + " tuplas eliminadas");
	        return resp;		 
		}
	 
	 public long eliminarEmpleadoPorNombre (String nombre)
		{
		 
		 log.info ("Eliminando Empleado por nombre: " + nombre);
	        long resp = pp.eliminarEmpleadoPorNombre (nombre);
	        log.info ("Eliminando Empleado: " + resp + " tuplas eliminadas");
	        return resp;	}
	 
	 
	 public List<Empleado> darEmpleado() {
		 
		 log.info ("Listando Empleados");
	        List<Empleado> empleado = pp.darEmpleado ();	
	        log.info ("Listando Empleados: " + empleado.size() + " bares existentes");
	        return empleado;
	 }
		
	 
	 public List<VOEmpleado> darVOEmpleado ()
		{
		 log.info ("Generando los VO de Empleado");
			List<VOEmpleado> voEmpleado = new LinkedList<VOEmpleado> ();
			for (Empleado bar: pp.darEmpleado ())
			{
				voEmpleado.add (bar);
			}
			log.info ("Generando los VO de Empleado: " + voEmpleado.size () + " Empleados existentes");
			return voEmpleado;
		}
	 
	 
	 /* ****************************************************************
		 * 			Métodos para manejar los EMPLEADO ACTIVO
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un EMPLEADO
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 
	 
	 
	 
	 public EmpleadoActivo adicionarEmpleadoActivo(long idHotel, long idEmpleado) {
		 
		 
		 log.info ("Adicionando empleado a el hotel: " + idEmpleado);
		 EmpleadoActivo bebedor = pp.adicionarEmpleadoActivo (idHotel, idEmpleado);
	        log.info ("Adicionando bebedor: " + bebedor);
	        return bebedor;
	 }
	 
	 
	 
	 public long eliminarEmpleadoActivoPorId (long idEmpleado)
		{
		 
		 log.info ("Eliminando Empleado Activo : " + idEmpleado);
	        long resp = pp.eliminarEmpleadoActivoPorId (idEmpleado);		
	        log.info ("Eliminando  Empleado Activo: " + resp + " tuplas eliminadas");
	        return resp;
		 
		}
	 
	 public long eliminarEmpleadoActivoPorReserva (long idReserva)
 	{
		 log.info ("Eliminando Empleado por reserva: " + idReserva);
	        long resp = pp.eliminarEmpleadoActivoPorReserva (idReserva);		
	        log.info ("Eliminando Empleado por reserva: " + resp + " tuplas eliminadas");
	        return resp;
 	}
	 
	 public List<EmpleadoActivo> darEmpleadoActivo() {
		 
		 log.info ("Consultando EmpleadoActivo");
	        List<EmpleadoActivo> bebidas = pp.darEmpleadoActivo ();	
	        log.info ("Consultando EmpleadoActivos: " + bebidas.size() + " EmpleadoActivos existentes");
	        return bebidas;
	 }
	 
	 
	 public  EmpleadoActivo darEmpleadoActivoPorId (PersistenceManager pm, long idEmpleado) 
 	{
		
	        log.info ("Dar información de un EmpleadoActivo por id: " + idEmpleado);
	        EmpleadoActivo bebedor = pp.darEmpleadoActivoPorId (idEmpleado);
	        log.info ("BuscandoEmpleadoActivo por Id: " + bebedor != null ? bebedor : "NO EXISTE");
	        return bebedor;
		}
	 
	 public List<EmpleadoActivo> darEmpleadoeActivoPorIdHotel(long idHotel) {
		 
		 
		 log.info ("Consultando EmpleadoActivo por Id Hotel ");
	        List<EmpleadoActivo> bebidas = pp.darEmpleadoeActivoPorIdHotel (idHotel);	
	        log.info ("Consultando EmpleadoActivos: " + bebidas.size() + " EmpleadoActivos existentes");
	        return bebidas;
	        }
	 
	 
	 
	 public List<EmpleadoActivo> darVOEmpleadoActivo ()
		{
			log.info ("Generando los VO de los EmpleadoActivo");       
	        List<EmpleadoActivo> voBebidas = new LinkedList<EmpleadoActivo> ();
	        for (EmpleadoActivo beb : pp.darEmpleadoActivo ())
	        {
	        	voBebidas.add (beb);
	        }
	        log.info ("Generando los VO de las EmpleadoActivo: " + voBebidas.size() + " existentes");
	        return voBebidas;
		}
	 
	 
	 
	 /* ****************************************************************
		 * 			Métodos para manejar los  Habitacion
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un EMPLEADO
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 	
	 
	 
	 
     public Habitacion adicionarHabitacion(String nombre,String tipoHabitacion,BigDecimal numeroHabitacion,BigDecimal idEmpleado) {
    	 
    	 log.info ("Adicionando Habitacion " + nombre);
    	 Habitacion bebida = pp.adicionarHabitacion (nombre, tipoHabitacion, numeroHabitacion,idEmpleado);
         log.info ("Adicionando Habitacion: " + bebida);
         return bebida;
   
     }
     
     
     public long eliminarHabitacionPorId (long idHabitacion)
 	{
    	 log.info ("Eliminando Habitacion por id: " + idHabitacion);
         long resp = pp.eliminarHabitacionPorId (idHabitacion);
         log.info ("Eliminando bebida por id: " + resp + " tuplas eliminadas");
         return resp;	 
 	}
     
     public long eliminarHabitacionPorNombre(String nombre) {
    	 
    	 log.info ("Eliminando Habitacion por nombre : " + nombre);
         long resp = pp.eliminarHabitacionPorNombre (nombre);
         log.info ("Eliminando Habitacion por nombre: " + resp + " tuplas eliminadas");
         return resp;
    	 
     }
     
     
     public long eliminarHabitacionPorTipo(String tipoHabitacion) {
    	 
    	 log.info ("Eliminando Habitacion por Tipo : " + tipoHabitacion);
         long resp = pp.eliminarHabitacionPorTipo (tipoHabitacion);
         log.info ("Eliminando Habitacion por Tipo: " + resp + " tuplas eliminadas");
         return resp; }
     
     
     
     public Habitacion darHabitacionPorId(long idHabitacion) {
    	 

         log.info ("Dar información de un Habitacion por id: " + idHabitacion);
         Habitacion bebedor = pp.darHabitacionPorId (idHabitacion);
         log.info ("Buscando Habitacion por Id: " + bebedor != null ? bebedor : "NO EXISTE");
         return bebedor;
     }

	 public List<Habitacion> darHabitacionPorTipo(String tipo) {
    	 

		log.info ("Dar información de un Habitacion por tipo: " + tipo);
		List<Habitacion> habitaciones = pp.darHabitacionPorTipo(tipo);
		log.info ("Buscando Habitacion por Id: " + habitaciones != null ? habitaciones : "NO EXISTE");
		return habitaciones;
	}
     
     
    public List<Habitacion> darHabitacion() {
    	log.info ("Listando Habitaciones");
        List<Habitacion> bebedores = pp.darHabitacion ();	
        log.info ("Listando Habitaciones: " + bebedores.size() + " Habitaciones existentes");
        return bebedores;
    }

	public List<Habitacion> darHabitacionesNoReservadas() {
		log.info ("Listando Habitaciones");
		List<Habitacion> habitaciones = pp.darHabitacionesNoReservadas();	
		log.info ("Listando Habitaciones: " + habitaciones.size() + " Habitaciones existentes");
		return habitaciones;
	}
     
     
     
     public List<VOHabitacion> darVOHabitacion ()
 	{
         log.info ("Generando los VO de Habitaciones");
          List<VOHabitacion> voBebedores = new LinkedList<VOHabitacion> ();
         for (Habitacion bdor : pp.darHabitacion ())
         {
         	voBebedores.add (bdor);
         }
         log.info ("Generando los VO de Habitaciones: " + voBebedores.size() + " Habitaciones existentes");
        return voBebedores;
 	}
     
     
     
    	 

     
     public List<VOHabitacionOfertada> darVOBebedoresPorNombre (long idHotel)
 	{
         log.info ("Generando VO de HabitacionOfertada por ID HOTEL: " + idHotel);
         List<VOHabitacionOfertada> voBebedores = new LinkedList<VOHabitacionOfertada> ();
        for (HabitacionOfertada bdor : pp.darHabitacionOfertadaPorIdHotel (idHotel))
        {
           	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de HabitacionOfertada ID HOTEL: " + voBebedores.size() + " HABITACION  existentes");
       return voBebedores;
  	}
     
     
     
     
     /* ****************************************************************
		 * 			Métodos para manejar los  Habitacion Ofertada
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un EMPLEADO
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 	

     
     
     public HabitacionOfertada adicionarHabitacionOfertada(long idHotel, long idHabitacion) {
    	 
    	 
    	 log.info ("Adicionando Habitacion Ofertada: " + idHabitacion);
    	 HabitacionOfertada bebedor = pp.adicionarHabitacionOfertada (idHotel, idHabitacion);
         log.info ("Adicionando bebedor: " + bebedor);
         return bebedor;
     }
     
     
     public long eliminarHabitacionOfertadaPorHotel(long idHotel) {
    	 
    	 log.info (" eliminar Habitacion Ofertada Por Hotel: " + idHotel);
         long resp = pp.eliminarHabitacionOfertadaPorHotel (idHotel);
         log.info ("eliminar Habitacion Ofertada Por Hotel: " + resp + " tuplas eliminadas");
         return resp;
     }
     
     
     public long eliminarHabitacionOfertadaPorId(long idHabitacion) {
    	 
    	 log.info (" eliminar Habitacion Ofertada Por ID: " + idHabitacion);
         long resp = pp.eliminarHabitacionOfertadaPorId (idHabitacion);
         log.info ("eliminar Habitacion Ofertada Por ID: " + resp + " tuplas eliminadas");
         return resp;	 
     }
     
     public List<HabitacionOfertada> darHabitacionOfertada() {
    	 
    	 log.info ("Listando Habitaciones Ofertadas");
         List<HabitacionOfertada> bebedores = pp.darHabitacionOfertada ();	
         log.info ("Listando Bebedores: " + bebedores.size() + " bebedores existentes");
         return bebedores;
    	 
    	 
     }
     
     public List<HabitacionOfertada> darHabitacionOfertadaPorIdHotel(long idHotel) {
    	 
    	 log.info ("Dar información de HabitacionOfertada por ID Hotel: " + idHotel);
         List<HabitacionOfertada> bebedores = pp.darHabitacionOfertadaPorIdHotel (idHotel);
         log.info ("Dar información de HabitacionOfertada por ID Hotel: " + bebedores.size() + " HabitacionOfertada con ese ID existentes");
         return bebedores;
         
     }
     
     
     public List<HabitacionOfertada> darHabitacionOfertadaPorId(long idHabitacion) {
    	 
    	 log.info ("Dar información de HabitacionOfertada por ID: " + idHabitacion);
         List<HabitacionOfertada> bebedores = pp.darHabitacionOfertadaPorId (idHabitacion);
         log.info ("Dar información de HabitacionOfertada por ID: " + bebedores.size() + " HabitacionOfertada con ese ID existentes");
         return bebedores;}
     
     
     public List<VOHabitacionOfertada> darVOHabitacionOfertada ()
 	{
    	 log.info ("Generando los VO de HabitacionOfertada");
         List<VOHabitacionOfertada> voBebedores = new LinkedList<VOHabitacionOfertada> ();
        for (HabitacionOfertada bdor : pp.darHabitacionOfertada ())
        {
        	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de HabitacionOfertada: " + voBebedores.size() + " HabitacionOfertada existentes");
       return voBebedores; 	 
 	}
     
     

     /* ****************************************************************
		 * 			Métodos para manejar los  Habitacion Reservada
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un Habitacion Reservada
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 	
     
     
     
     
     public HabitacionReservada adicionarHabitacionReservada(BigDecimal idHabitacion, BigDecimal idReserva, BigDecimal idCuenta) {
    	 
    	 log.info ("Adicionando Habitacion Reservada: " + idHabitacion);
    	 HabitacionReservada bebedor = pp.adicionarHabitacionReservada (idHabitacion, idReserva, idCuenta);
         log.info ("Adicionando bebedor: " + bebedor);
         return bebedor;	 
     }
     
     
     public long eliminarHabitacionReservadaPorId(BigDecimal idHabitacion) {
    	 
    	 log.info ("Eliminando Habitacion Reservada por ID Habitacion: " + idHabitacion);
         long resp = pp.eliminarHabitacionReservadaPorId (idHabitacion);
         log.info (" Eliminando Habitacion Reservada por ID  Habitacion: " + resp + " tuplas eliminadas");
         return resp;
     }
     
     
     public long eliminarHabitacionReservadaPorIdReserva(BigDecimal idReserva) {
    	 
    	 log.info ("Eliminando Habitacion Reservada por ID Reserva: " + idReserva);
         long resp = pp.eliminarHabitacionReservadaPorIdReserva (idReserva);
         log.info (" Eliminando Habitacion Reservada por ID Reserva: " + resp + " tuplas eliminadas");
         return resp;
    	 
    	 
    	 
     }
     
     public long eliminarHabitacionReservadaPorIdCuenta(long idCuenta) {
    	 
    	 log.info ("Eliminando Habitacion Reservada por ID Cuenta: " + idCuenta);
         long resp = pp.eliminarHabitacionReservadaPorIdCuenta (idCuenta);
         log.info (" Eliminando Habitacion Reservada por ID Cuenta: " + resp + " tuplas eliminadas");
         return resp;   	 
     }
     
     ///
     public List<HabitacionReservada> darHabitacionReservadaPorIdHabitacion(long idHabitacion) {
    	 
    	 log.info (" dar  informacion Habitacion Reservada por ID Habitacion: " + idHabitacion);
         List<HabitacionReservada> bebedores = pp.darHabitacionReservadaPorId (idHabitacion);
         log.info ("dar  informacion Habitacion Reservada por ID Habitacion : " + bebedores.size() + " Habitacion Reservada con ID  existentes");
         return bebedores;
	 
     }

	public List<HabitacionReservada> darHabitacionReservadaPorIdReserva(long idReserva) {
		log.info (" dar  informacion Habitacion Reservada por ID reserva: " + idReserva);
        List<HabitacionReservada> hReservadas = pp.darHabitacionReservadaPorId (idReserva);
        log.info ("dar  informacion Habitacion Reservada por ID reserva : " + hReservadas.size() + " Habitacion Reservada existentes");
        return hReservadas;

	}
     
     public List<VOHabitacionReservada> darVOHabitacionReservada (long idHabitacion)
 	{
         log.info ("Generando VO de VOHabitacionReservada por nombre: " + idHabitacion);
         List<VOHabitacionReservada> voBebedores = new LinkedList<VOHabitacionReservada> ();
        for (HabitacionReservada bdor : pp.darHabitacionReservadaPorId (idHabitacion))
        {
           	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de HabitacionReservada: " + voBebedores.size() + " Habitaciones existentes");
       return voBebedores;
  	}
 
     
     public List<HabitacionReservada> darHabitacionReservada() {
    	 
    	 log.info ("Listando HabitacionReservada");
         List<HabitacionReservada> bebedores = pp.darHabitacionReservada ();	
         log.info ("Listando Bebedores: " + bebedores.size() + " bebedores existentes");
         return bebedores;
     }
     
     
     
     /* ****************************************************************
		 * 			Métodos para manejar los  HOTEL
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un Habitacion Reservada
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 	
     
     
     
     public Hotel adicionarHotel ( String nombre, String ubicacion, String paginaweb, long numero) 
 	{
    	 log.info ("Adicionando HOTEL: " + nombre);
    	 Hotel bebedor = pp.adicionarHotel (nombre, ubicacion, paginaweb,numero);
         log.info ("Adicionando HOTEL: " + bebedor);
         return bebedor;    	 
 	}
     
     
     public long eliminarHotelPorNombre (String nombre) 
 	{
    	 log.info ("Eliminando Hotel por nombre: " + nombre);
         long resp = pp.eliminarHotelPorNombre (nombre);
         log.info ("Eliminando Hotel por nombre: " + resp + " tuplas eliminadas");
         return resp;
    	 
 	}
     
     public long eliminaHotelPorId (long idHotel) 
 	{
    	 log.info ("Eliminando Hotel por ID: " + idHotel);
         long resp = pp.eliminaHotelPorId (idHotel);
         log.info ("Eliminando Hotel por ID: " + resp + " tuplas eliminadas");
         return resp;
 	}
     
     public List<Hotel> darHoteles ()
 	{
    	 
    	 log.info ("Listando Hoteles");
         List<Hotel> bebedores = pp.darHoteles ();	
         log.info ("Listando Hoteles: " + bebedores.size() + " Hoteles existentes");
         return bebedores;
 	}
     
     public List<Hotel> darHotelesPorNombre (String nombre)
 	{
    	 log.info ("Dar información de Hoteles por nombre: " + nombre);
         List<Hotel> bebedores = pp.darHotelesPorNombre (nombre);
         log.info ("Dar información de Hoteles por nombre: " + bebedores.size() + " Hoteles con ese nombre existentes");
         return bebedores;
 	}
     
     
     public Hotel darHotelPorId (long idHotel)
 	{
    	 log.info ("Dar información de un Hotel por id: " + idHotel);
    	 Hotel bebedor = pp.darHotelPorId (idHotel);
         log.info ("Buscando Hotel por Id: " + bebedor != null ? bebedor : "NO EXISTE");
         return bebedor;
    	 
 	}
     
     
     public List<VOHotel> darVOHotel (String idHabitacion)
  	{
    	 log.info ("Generando VO de Hoteles por nombre: " + idHabitacion);
         List<VOHotel> voBebedores = new LinkedList<VOHotel> ();
         
        for (Hotel bdor : pp.darHotelesPorNombre (idHabitacion))
        {
           	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de Hoteles: " + voBebedores.size() + " Hoteles existentes");
       return voBebedores;
   	}
     
     
     
     
     
     
     
     /* ****************************************************************
		 * 			Métodos para manejar los  Metodo de Pago
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un Metodo de Pago
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 	
     
     
     public MetododePago adicionarMetodopago (String tipo, String nombre) 
 	{
    	 log.info ("Adicionando Metodo pago: " + nombre);
    	 MetododePago bar = pp.adicionarMetodopago (tipo, nombre);
         log.info ("Adicionando Metodo pago: " + bar);
         return bar;
 	}
     
     
 	public long eliminarMetodopagoPorNombre(String nombre) {
 		
 		log.info ("Eliminando Metodo por nombre: " + nombre);
        long resp = pp.eliminarMetodopagoPorNombre (nombre);
        log.info ("Eliminando Metodo por nombre: " + resp + " tuplas eliminadas");
        return resp;		
 	}
 	
 	public long eliminaMetodopagoPorId (long idMetodoPago) 
	{
 		log.info ("Eliminando Metodo por ID: " + idMetodoPago);
        long resp = pp.eliminaMetodopagoPorId (idMetodoPago);
        log.info ("Eliminando Metodo por ID: " + resp + " tuplas eliminadas");
        return resp;
 		
	}
 	
 	
 	public MetododePago darMetododePagoPorNombre (String nombre) 
	{
 		log.info ("Dar información Metodo de Pago Po rNombre : " + nombre);
 		MetododePago bebedor =  pp.darMetododePagoPorNombre (nombre);
        log.info ("Buscando información Metodo de Pago Po rNombre : " + bebedor != null ? nombre : "NO EXISTE");
        return bebedor;
	}
 	
 	
 	public List<MetododePago> darMetododePagos ()
	{
 		log.info ("Listando Metodo de pago");
        List<MetododePago> bebedores = pp.darMetododePagos ();	
        log.info ("Listando Metodo de pago: " + bebedores.size() + "  Metodo de pago existentes");
        return bebedores;
	}
 	
 	  public List<VOMetododePago> darVOMetododePago ( )
 	  	{
 	    	 log.info ("Generando VO de Metodo de Pago: " );
 	         List<VOMetododePago> voBebedores = new LinkedList<VOMetododePago> ();
 	         
 	        for (MetododePago bdor : pp.darMetododePagos ())
 	        {
 	           	voBebedores.add (bdor);
 	        }
 	        log.info ("Generando los VO de  Metodo de Pago: " + voBebedores.size() + "  Metodo de Pago existentes");
 	       return voBebedores;
 	   	}
 	  
 	  

      /* ****************************************************************
 		 * 			Métodos para manejar los  Plan de Consumo
 		 *****************************************************************/
 		/**
 		 * Adiciona de manera persistente un Metodo de Pago
 		 * Adiciona entradas al log de la aplicación
 		 * 
 		 * 
 		 */	 	
 	  
 	 public PlanDeConsumo adicionarPlanDeConsumo(String nombre, int costo, Timestamp vigencia) 
 	{
 		 log.info ("Adicionando PLan de consumo: " + nombre);
 		PlanDeConsumo bebedor = pp.adicionarPlanDeConsumo (nombre, costo, vigencia);
         log.info ("Adicionando PLan de consumo: " + bebedor);
         return bebedor;
 	}
 	 
 	 
 	public long eliminarPlanDeConsumoPorNombre(String nombre) 
	{
 		log.info ("Eliminando PLan de consumo por nombre: " + nombre);
        long resp = pp.eliminarPlanDeConsumoPorNombre (nombre);
        log.info ("Eliminando PLan de consumo por nombre: " + resp + " tuplas eliminadas");
        return resp;
 		
	}
 	
 	
 	public long eliminaPlanDeConsumoPorId (long idPlanConsumo) 
	{
 		log.info ("Eliminando PLan de consumo por ID: " + idPlanConsumo);
        long resp = pp.eliminaPlanDeConsumoPorId (idPlanConsumo);
        log.info ("Eliminando PLan de consumo por ID: " + resp + " tuplas eliminadas");
        return resp;
 		
	}
 	
 	public List<PlanDeConsumo> darPlanDeConsumosPorNombre (String nombre) 
	{
 		log.info ("Dar información de  Plan De Consumo: " + nombre);
        List<PlanDeConsumo> bebedores = pp.darPlanDeConsumosPorNombre (nombre);
        log.info ("Dar información de Plan De Consumo: " + bebedores.size() + "  Plan De Consumo con ese nombre existentes");
        return bebedores;
 		
	}
 	
 	public PlanDeConsumo darPlanDeConsumoPorId (long idPlanConsumo) 
	{
 		log.info ("Dar información de un Plan De Consumo: " + idPlanConsumo);
 		PlanDeConsumo bebedor = pp.darPlanDeConsumoPorId (idPlanConsumo);
        log.info ("BuscandoPlan De Consumo : " + bebedor != null ? bebedor : "NO EXISTE");
        return bebedor;
	}
 	
 	
 	public List<PlanDeConsumo> darPlanDeConsumos ()
	{	
 		log.info ("Listando Planes De Consumo");
        List<PlanDeConsumo> bebedores = pp.darPlanDeConsumos ();	
        log.info ("Listando Planes De Consumo: " + bebedores.size() + " Planes De Consumo existentes");
        return bebedores;	
	}
 	
 	public List<VOPlanDeConsumo> darVOPlanDeConsumo (String idHabitacion)
	  	{
	    	 log.info ("Generando VO de Planes De Consumoo: " + idHabitacion);
	         List<VOPlanDeConsumo> voBebedores = new LinkedList<VOPlanDeConsumo> ();
	         
	        for (PlanDeConsumo bdor : pp.darPlanDeConsumosPorNombre (idHabitacion))
	        {
	           	voBebedores.add (bdor);
	        }
	        log.info ("Generando los VO de Planes De Consumo: " + voBebedores.size() + " Planes De Consumo existentes");
	       return voBebedores;
	   	}
 	
 	
 	 /* ****************************************************************
		 * 			Métodos para manejar los  Plan de Ofrecido
		 *****************************************************************/
		/**
		 * Adiciona de manera persistente un Metodo de Pago
		 * Adiciona entradas al log de la aplicación
		 * 
		 * 
		 */	 
 	
 	
 	public PlanOfrecido adicionarPlanOfrecido(long idPlanConsumo, long idHotel) 
	{
 		log.info ("Adicionando PLan de Ofrecido: " + idPlanConsumo);
 		PlanOfrecido bebedor = pp.adicionarPlanOfrecido (idPlanConsumo, idHotel);
         log.info ("Adicionando PLan de Ofrecido: " + bebedor);
         return bebedor;
         }
 	
 	public long eliminarPlanOfrecido(long idPlanConsumo, long idHotel) 
	{
 		log.info ("Eliminando PLan de ofrecido por id: " + idPlanConsumo);
        long resp = pp.eliminarPlanOfrecido (idPlanConsumo,idHotel);
        log.info ("Eliminando PLan de ofrecido por id: " + resp + " tuplas eliminadas");
        return resp;	
	}
 	

	public List<PlanOfrecido> darPlanOfrecidos ()
	{
		log.info ("Listando Plan Ofrecidos");
        List<PlanOfrecido> gustan = pp.darPlanOfrecidos ();	
        log.info ("Listando Plan Ofrecidos: " + gustan.size() + " preferencias de Plan Ofrecidos existentes");
        return gustan;
	}
	
	
	public List<VOPlanOfrecido> darVOPlanOfrecido ( )
  	{
    	 log.info ("Generando VO de Planes Ofrecidos: ");
         List<VOPlanOfrecido> voBebedores = new LinkedList<VOPlanOfrecido> ();
         
        for (PlanOfrecido bdor : pp.darPlanOfrecidos ())
        {
           	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de Planes  Ofrecidos: " + voBebedores.size() + " Planes  Ofrecidos existentes");
       return voBebedores;
   	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Reserva
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	 
	
	public Reserva adicionarReserva(Timestamp fechaEntrada, Timestamp fechaSalida, BigDecimal numeroPersonas, BigDecimal idCliente,BigDecimal plan_de_pago,String estado) 
	{
		log.info ("Adicionando  Reserva fechaEntrada: " + fechaEntrada);
		Reserva bebedor = pp.adicionarReserva (fechaEntrada, fechaSalida,numeroPersonas,idCliente, plan_de_pago, estado);
         log.info ("Adicionando Reserva: " + bebedor);
         return bebedor;		
	}
	
	public long eliminarReservasPorEstado ( String estado)
	{
		log.info ("Eliminando Reserva por id cliente: " + estado);
        long resp = pp.eliminarReservasPorEstado (estado);
        log.info ("Eliminando Reserva: " + resp + " tuplas eliminadas");
        return resp;
		
		
	}
	
	public long eliminarReservasPorplan_de_pago ( int plan_de_pago)
	{
		log.info ("Eliminando Reserva por id cliente: " + plan_de_pago);
        long resp = pp.eliminarReservasPorplan_de_pago (plan_de_pago);
        log.info ("Eliminando Reserva: " + resp + " tuplas eliminadas");
        return resp;	
	}
	

	
	public long eliminarReservasPorIdcliente ( long idCliente) 
	{
		log.info ("Eliminando Reserva por id cliente: " + idCliente);
        long resp = pp.eliminarReservasPorIdcliente (idCliente);
        log.info ("Eliminando Reserva: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	public long eliminaReservaPorId ( long idReserva) 
	{
		log.info ("Eliminando Reserva por ID: " + idReserva);
        long resp = pp.eliminaReservaPorId (idReserva);
        log.info ("Eliminando Reserva por ID: " + resp + " tuplas eliminadas");
        return resp;
        }
	
	public List<Reserva> darReservasPorestado(String estado) 
	{
		log.info ("Dar información de reservas  De id cliente: " + estado);
        List<Reserva> bebedores = pp.darReservasPorestado (estado);
        log.info ("Dar información de reservas  De id cliente:: " + bebedores.size() + "  reservas con ese cliente  existentes");
        return bebedores;
	
	}
	
	public List<Reserva> darReservasPorIdcliente (long idCliente)
	{
		log.info ("Dar información de reservas  De id cliente: " + idCliente);
        List<Reserva> bebedores = pp.darReservasPorIdcliente (idCliente);
        log.info ("Dar información de reservas  De id cliente:: " + bebedores.size() + "  reservas con ese cliente  existentes");
        return bebedores;
		
	}

	public List<Reserva> darReservasPorPlanPago (BigDecimal idPlanPago)
	{
		log.info ("Dar información de reservas de plan de pago: " + idPlanPago);
        List<Reserva> reservas = pp.darReservasPorIdPlanPago(idPlanPago);
        log.info ("Dar información de reservas de plan de pago: " + reservas.size() + "  reservas con ese plan de pago");
        return reservas;
		
	}
	
	public List<Reserva> darReservas ()
	{
		log.info ("Listando reservas");
        List<Reserva> gustan = pp.darReservas ();	
        log.info ("Listando reservas: " + gustan.size() + " preferencias de reservas existentes");
        return gustan;
	}
	
	public long aumentarNumeroPersonasReserva (long idReserva)
	{		
		log.info ("Aumentando personas de la reserva : " + idReserva);
        long resp = pp.aumentarNumeroPersonasReserva (idReserva);
        log.info (" Aumentando personas de la reserva: " + resp + " tuplas eliminadas");
        return resp;		
	}

	public long liberarReserva (BigDecimal idReserva)
	{		
		log.info ("Liberando reserva : " + idReserva);
        long resp = pp.liberarReserva(idReserva);
        log.info (" Liberando la reserva: " + resp);
        return resp;		
	}
	
	
	public List<VOReserva> darVOReserva (long idCliente)
  	{
    	 log.info ("Generando VO de Reservas: " + idCliente);
         List<VOReserva> voBebedores = new LinkedList<VOReserva> ();
         
        for (Reserva bdor : pp.darReservasPorIdcliente (idCliente))
        {
           	voBebedores.add (bdor);
        }
        log.info ("Generando los VO de Reservas: " + voBebedores.size() + " Reservas existentes");
       return voBebedores;
   	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Servicio 
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	 
	
	public Servicio adicionarServicio(String nombre, String descripcion, BigDecimal area, BigDecimal costo) 
	{
		log.info ("Adicionando  servicio : " + nombre);
		Servicio bebedor = pp.adicionarServicio (nombre, descripcion,area, costo);
         log.info ("Adicionando servicio: " + bebedor);
         return bebedor;		
	}
	
	public long eliminarServicioPorNombre (String nombre) 
	{
		log.info ("Eliminando servicio por id nombre: " + nombre);
        long resp = pp.eliminarServicioPorNombre (nombre);
        log.info ("Eliminando servicio: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	public long eliminaServicioPorId (BigDecimal idServicio) 
	{
		log.info ("Eliminando servicio por id : " + idServicio);
        long resp = pp.eliminaServicioPorId (idServicio);
        log.info ("Eliminando servicio: " + resp + " tuplas eliminadas");
        return resp;
		
	}
	
	public List<Servicio> darServicios ()
	{
		
		log.info ("Listando servicios");
        List<Servicio> gustan = pp.darServicios ();	
        log.info ("Listando servicios: " + gustan.size() + " preferencias de servicios existentes");
        return gustan;	
	}
	
	
	public List<Servicio> darServicioPorNombre (String nombre)
	{
		log.info ("Dar información de reservas  De nombre: " + nombre);
        List<Servicio> bebedores = pp.darServicioPorNombre (nombre);
        log.info ("Dar información de reservas  De nombre : " + bebedores.size() + "  reservas con ese nombre  existentes");
        return bebedores;
		
	}
	
	public List<VOServicio> darVOServicio (String nombre)
	{
        log.info ("Generando VO de Servicios por nombre: " + nombre);
        List<VOServicio> voBebedores = new LinkedList<VOServicio> ();
       for (Servicio bdor : pp.darServicioPorNombre (nombre))
       {
          	voBebedores.add (bdor);
       }
       log.info ("Generando los VO de servicios: " + voBebedores.size() + "  existentes");
      return voBebedores;
 	}
	
	
	
	
	
	
	
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Servicio Ofrecido
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	 
	
	
	public ServicioOfrecido adicionarServicioOfrecido(long idServicio, long idHotel) 
	{
		log.info ("Adicionando  Servicio Ofrecido: " + idServicio);
		ServicioOfrecido bebedor = pp.adicionarServicioOfrecido (idServicio, idHotel);
         log.info ("Adicionando  Servicio Ofrecido: " + bebedor);
         return bebedor;
		
	}
	
	
	public long eliminarServicioOfrecido(long idServicio, long idHotel) 
	{
		log.info ("Eliminando ServicioOfrecido por Id Hotel : " + idHotel);
        long resp = pp.eliminarServicioOfrecido (idServicio,idHotel);
        log.info ("Eliminando bar: " + resp + " tuplas eliminadas");
        return resp;
		
	}
	
	
	public List<ServicioOfrecido> darServicioOfrecido ()
	{
		log.info ("Listando Servicios Ofrecidos");
        List<ServicioOfrecido> gustan = pp.darServicioOfrecido ();	
        log.info ("Listando Servicios Ofrecidos: " + gustan.size() + " preferencias de Servicios Ofrecidos existentes");
        return gustan;
		
	}
	
	
	public List<VOServicioOfrecido> darVOServicioOfrecido ()
	{
		log.info ("Generando los VO de Servicios Ofrecidos");
		List<VOServicioOfrecido> voGustan = new LinkedList<VOServicioOfrecido> ();
		for (VOServicioOfrecido bar: pp.darServicioOfrecido ())
		{
			voGustan.add (bar);
		}
		log.info ("Generando los VO de Servicios Ofrecidos: " + voGustan.size () + " son servicios ofrecidos existentes");
		return voGustan;
	}
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Servicio Solicitado
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	
	
	public ServicioSolicitado adicionarServicio_Solicitado (BigDecimal idServicio,BigDecimal numpersonas, BigDecimal Costo,Timestamp fecha_solicitud) 
	{
		log.info ("Adicionando  Servicio numero de personas: " + numpersonas);
		ServicioSolicitado bebedor = pp.adicionarServicio_Solicitado (idServicio, numpersonas, Costo,fecha_solicitud);
         log.info ("Adicionando  Servicio Ofrecido: " + bebedor);
         return bebedor;
		
	}
	
	public long eliminarServicio_SolicitadoPorId(long idServicio)
	{
		log.info ("Eliminando Servicio Solicitado por Id  : " + idServicio);
        long resp = pp.eliminarServicio_SolicitadoPorId (idServicio);
        log.info ("Eliminando Servicio: " + resp + " tuplas eliminadas");
        return resp;
	
	}
	
	
	public ServicioSolicitado  darServicio_SolicitadopoID (long idServicio) 
	{
		log.info ("Dar información de Servicio_Solicita por ID: " + idServicio);
        ServicioSolicitado bebedor = pp.darServicio_SolicitadopoID (idServicio);
        log.info ("Buscando servicio por Id: " + bebedor != null ? bebedor : "NO EXISTE");
        return bebedor;
		
	}
	
	public List<ServicioSolicitado>  darServicio_Solicitadoporfecha_solicitud ( Timestamp fecha_solicitud) {
		
		log.info ("Listando ServicioSolicitado");
        List<ServicioSolicitado> bebedores = pp.darServicio_Solicitadoporfecha_solicitud (fecha_solicitud);	
        log.info ("Listando ServicioSolicitado: " + bebedores.size() + " bebedores existentes");
        return bebedores;
		
		
        
	}

	
	public  List<ServicioSolicitado> darServicio_Solicitado ()
	{
		
		log.info ("Listando ServicioSolicitado");
        List<ServicioSolicitado> bebedores = pp.darServicio_Solicitado ();	
        log.info ("Listando ServicioSolicitado: " + bebedores.size() + " bebedores existentes");
        return bebedores;
	}
	
	public List<VOServicioOfrecido> darVOServicioSolicitado ()
	{
		log.info ("Generando los VO de Servicios Solicitados");
		List<VOServicioOfrecido> voGustan = new LinkedList<VOServicioOfrecido> ();
		for (VOServicioSolicitado bar: pp.darServicio_Solicitado ())
		{
			voGustan.add ((VOServicioOfrecido) bar);
		}
		log.info ("Generando los VO de Servicios Ofrecidos: " + voGustan.size () + " son servicios ofrecidos existentes");
		return voGustan;
	}
	
	
	
	public long aumentarnumeroPersonasServicio_SolicitadoID ( long idServicio)
	{
		
		log.info ("Dar información de  aumentarnumeroPersonasServicio_SolicitadoID: " + idServicio);
        long bebedor = pp.aumentarnumeroPersonasServicio_SolicitadoID (idServicio);
        log.info ("Buscando aumentarnumeroPersonasServicio_SolicitadoID: " + bebedor != null ? bebedor : "NO EXISTE");
        return bebedor;
		
		
		
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Tipo Habitacion
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	
	
	
	public TipoHabitacion adicionarTipo_Habitacion (String tipoHabitacion , BigDecimal capacidad, BigDecimal area) 
	{
		
		log.info ("Adicionando  tipo de Habitacion: " + tipoHabitacion);
		TipoHabitacion bebedor = pp.adicionarTipo_Habitacion (tipoHabitacion, capacidad,area);
         log.info ("Adicionando  Servicio Ofrecido: " + bebedor);
         return bebedor;	
	}
	
	
	public List<TipoHabitacion> darTipo_Habitacion ()
	{
		
		log.info ("Listando tipo de Habitacion");
        List<TipoHabitacion> bebedores = pp.darTipo_Habitacion ();	
        log.info ("Listando tipo de Habitacion: " + bebedores.size() + " tipo de Habitacion existentes");
        return bebedores;
	
	}
	
	public long eliminarTipo_Habitacion( String tipoHabitacion) 
	{
		
		log.info ("Eliminando Tipo de Habitacion : " + tipoHabitacion);
        long resp = pp.eliminarTipo_Habitacion (tipoHabitacion);
        log.info ("Eliminando ipo de Habitacion: " + resp + " tuplas eliminadas");
        return resp;
		
	}
	
	public TipoHabitacion darTipo_HabitacionPortipoHabitacion (String tipoHabitacion)
	{
		
		log.info ("Dar información de Tipo de Habitacion por Id HABITACION: " + tipoHabitacion);
		TipoHabitacion bebedor = pp.darTipo_HabitacionPortipoHabitacion (tipoHabitacion);
        log.info ("Buscando  Tipo de Habitacion por Id: " + bebedor != null ? bebedor : "NO EXISTE");
        return bebedor;
		
	}
	
	
	public List<VOTipoHabitacion> darVOTipoHabitacion ()
	{
        log.info ("Generando VO de TipoHabitacio: ");
        List<VOTipoHabitacion> voBebedores = new LinkedList<VOTipoHabitacion> ();
       for (TipoHabitacion bdor : pp.darTipo_Habitacion())
       {
          	voBebedores.add (bdor);
       }
       log.info ("Generando los VO de BTipoHabitacio: " + voBebedores.size() + " TipoHabitacio existentes");
      return voBebedores;
 	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los  Tipo Habitacion
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un Metodo de Pago
	 * Adiciona entradas al log de la aplicación
	 * 
	 * 
	 */	
	
	
	public TipoReserva adicionarTipoReserva(long idReserva, long idPlanConsumo) 
	{
		log.info ("Adicionando  tipo de Reseva: " + idReserva);
		TipoReserva bebedor = pp.adicionarTipoReserva (idReserva, idPlanConsumo);
         log.info ("Adicionando  tipo de Reseva: " + bebedor);
         return bebedor;
		
	}
	
	public long eliminarTipoReserva(long idReserva, long idPlanConsumo) 
	{
		
		log.info ("Eliminando TipoReserva por id reserva: " + idReserva);
        long resp = pp.eliminarTipoReserva (idReserva,idPlanConsumo);
        log.info ("Eliminando TipoReserva por Id: " + resp + " tuplas eliminadas");
        return resp;
		
	}
	
	
	public List<TipoReserva> darTipoReserva ()
	{
		log.info ("Listando TipoReserva");
        List<TipoReserva> bebedores = pp.darTipoReserva ();	
        log.info ("Listando TipoReserva: " + bebedores.size() + " bebedores existentes");
        return bebedores;
	}

	/* ****************************************************************
	 * 			Métodos para manejar los roles de usuario
	 ******************************************************************
	 */	
	
	
	public RolUsuario adicionarRolUsuario(BigDecimal numero_documento, String rol) 
	{
		log.info ("Adicionando  tipo de Reseva: " + numero_documento);
		RolUsuario rolUsuario = pp.adicionarRolUsuario (numero_documento, rol);
        log.info ("Adicionando  tipo de Reseva: " + rolUsuario);
        return rolUsuario;
		
	}
	
	public long eliminarRolUsuario(long numero_documento) 
	{
		
		log.info ("Eliminando RolUsuario: " + numero_documento);
        long resp = pp.eliminarRolUsuario(numero_documento);
        log.info ("Eliminando RolUsuario: " + resp + " tuplas eliminadas");
        return resp;
		
	}

	public RolUsuario darRolUsuarioPorNumeroDocumento(long numero_documento){
		log.info("Buscando rol del usuario: "+ numero_documento);
		RolUsuario rolUsuario = pp.darRolUsuarioPorNumeroDocumento(numero_documento);
		log.info("Buscando rol del usuario: "+ rolUsuario != null ? rolUsuario : "No existe");
		return rolUsuario;
	}
	
	
	public List<RolUsuario> darRolUsuario ()
	{
		log.info ("Listando RolUsuario");
        List<RolUsuario> rolesU = pp.darRolesUsuario();	
        log.info ("Listando RolUsuario: " + rolesU.size() + " bebedores existentes");
        return rolesU;
	}

	/* ****************************************************************
	 * 			Métodos para manejar los organizadores de eventos
	 ******************************************************************
	 */

	public OrganizadorEventos adicionarOrganizadorEventos(BigDecimal idUsuario,BigDecimal numero_documento, String nombre, String apellido, String correo, BigDecimal planDePagoAcordado) 
	{
		log.info ("Adicionando organizador de eventos: " + numero_documento + " con plan de pago " + planDePagoAcordado);
		OrganizadorEventos organizadorEventos = pp.adicionarOrganizadorEventos(idUsuario, numero_documento, nombre, apellido, correo, planDePagoAcordado);
        log.info ("Adicionando  organizador de eventos: " + numero_documento + " con plan de pago " + planDePagoAcordado);
        return organizadorEventos;
		
	}
	
	
	public long eliminarOrganizadorEventos(long numero_documento, long planDePagoAcordado) 
	{
		log.info ("Eliminando organizador de eventos: " + numero_documento);
        long resp = pp.eliminarOrganizadorEventos(numero_documento, planDePagoAcordado);
        log.info ("Eliminando organizador de eventos: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	
	public List<OrganizadorEventos> darOrganizadorEventos ()
	{
		log.info ("Listando organizadores de eventos:");
        List<OrganizadorEventos> rolesU = pp.darOrganizadorEventos();	
        log.info ("Listando organizadores de eventos: " + rolesU.size() + " organizadores de eventos existentes");
        return rolesU;
	}

	/* ****************************************************************
	 * 			Métodos para manejar planes de pago acordados
	 ******************************************************************
	 */

    public PlanDePagoAcordado adicionarPlanDePagoAcordado(String tipoHabitaciones, int numeroHabitaciones, int numeroPersonas, Timestamp fechaInicio, Timestamp fechaSalida, String estado) 
    {
		log.info ("Adicionando plan de pago acordado: ");
		PlanDePagoAcordado planDePagoAcordado = pp.adicionarPlanDePagoAcordado(tipoHabitaciones, numeroHabitaciones, numeroPersonas, fechaInicio, fechaSalida, estado);
        log.info ("Adicionando  plan de pago acordado: ");
        return planDePagoAcordado;
            
    }
        
    public long eliminarPlanDePagoAcordadosPorEstado ( String estado)
    {	
        log.info ("Eliminando planes de pago acordado con estado: " + estado);
        long resp = pp.eliminarPlanDePagoAcordadosPorEstado(estado);
        log.info ("Eliminando planes de pago acordado con estado: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    public long eliminarPlanDePagoAcordadosPorTipoHabitacion ( String tipoHabitacion)
    {
        log.info ("Eliminando planes de pago acordado con tipo de habitacion: " + tipoHabitacion);
        long resp = pp.eliminarPlanDePagoAcordadosPorTipoHabitacion(tipoHabitacion);
        log.info ("Eliminando planes de pago acordado con tipo de habitacion: " + resp + " tuplas eliminadas");
        return resp;
        
    }
    
    public long eliminaPlanDePagoAcordadoPorId ( long idPlanDePagoAcordado) 
    {
		log.info ("Eliminando plan de pago acordado: " + idPlanDePagoAcordado);
        long resp = pp.eliminaPlanDePagoAcordadoPorId(idPlanDePagoAcordado);
        log.info ("Eliminando plan de pago acordado: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    public List<PlanDePagoAcordado> darPlanDePagoAcordadosPorestado(String estado) 
    {
        log.info ("Listando planes de pago acordados con estado "+ estado);
        List<PlanDePagoAcordado> planesDePagoAcordados = pp.darPlanDePagoAcordadosPorestado(estado);	
        log.info ("Listando RolUsuario: " + planesDePagoAcordados.size() + " planes de pago acordados existentes con estado "+ estado);
        return planesDePagoAcordados;

    }

    public List<PlanDePagoAcordado> darPlanDePagoAcordadosPorTipoHabitacion(String tipoHabitacion) 
    {
        log.info ("Listando planes de pago acordados con tipo de habitacion "+ tipoHabitacion);
        List<PlanDePagoAcordado> planesDePagoAcordados = pp.darPlanDePagoAcordadosPorTipoHabitacion(tipoHabitacion);	
        log.info ("Listando RolUsuario: " + planesDePagoAcordados.size() + " planes de pago acordados existentes con tipo de habitacion "+ tipoHabitacion);
        return planesDePagoAcordados;

    }
    
    public List<PlanDePagoAcordado> darPlanDePagoAcordados ()
    {
		log.info ("Listando planes de pago acordados:");
        List<PlanDePagoAcordado> planesDePagoAcordados = pp.darPlanDePagoAcordados();	
        log.info ("Listando RolUsuario: " + planesDePagoAcordados.size() + " planes de pago acordados existentes");
        return planesDePagoAcordados;
        
    }

	/* ****************************************************************
	 * 			Requerimientos de consulta
	 *****************************************************************/
	
	public List<String> consulta1(String fechaInicio, String fechaFin)
	{
		log.info ("Realizando requerimiento de consulta 1:");
        List<String> consulta1 = pp.consulta1(fechaInicio, fechaFin);	
        log.info ("Listando Req 1: " + consulta1.size() + " encontrados");
        return consulta1;
	}

	public List<Consulta7> consulta7()
	{
		log.info ("Realizando requerimiento de consulta 7:");
        List<Consulta7> consulta7 = pp.consulta7();	
        log.info ("Listando Req 7: " + consulta7.size() + " encontrados");
        return consulta7;
	}

	public List<Consulta8> consulta8()
	{
		log.info ("Realizando requerimiento de consulta 8:");
        List<Consulta8> consulta8 = pp.consulta8();	
        log.info ("Listando Req 8: " + consulta8.size() + " encontrados");
        return consulta8;
	}

	public List<Consulta9> consulta9()
	{
		log.info ("Realizando requerimiento de consulta 9:");
        List<Consulta9> consulta9 = pp.consulta9();	
        log.info ("Listando Req 9: " + consulta9.size() + " encontrados");
        return consulta9;
	}

	public List<Consulta10> consulta10()
	{
		log.info ("Realizando requerimiento de consulta 10:");
        List<Consulta10> consulta10 = pp.consulta10();	
        log.info ("Listando Req 10: " + consulta10.size() + " encontrados");
        return consulta10;
	}

	public List<Consulta12> consulta12()
	{
		log.info ("Realizando requerimiento de consulta 12:");
        List<Consulta12> consulta12 = pp.consulta12();	
        log.info ("Listando Req 12: " + consulta12.size() + " encontrados");
        return consulta12;
	}

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	
	public long [] limpiarHotelandes ()
	{
        log.info ("Limpiando la BD de Hotelandes");
        long [] borrrados = pp.limpiarHotelAndes();	
        log.info ("Limpiando la BD de Hotelandes: Listo!");
        return borrrados;
	}

	

  
	
	
	
	
}
