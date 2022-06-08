package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Habitacion;

public class SQLHabitacion {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLHabitacion (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarHabitacion (PersistenceManager pm, BigDecimal idHabitacion,String nombre,String tipoHabitacion,BigDecimal numeroHabitacion,BigDecimal idEmpleado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaHabitacion () + "(idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idEmpleado) values (?, ?, ?, ?, ?)");
        q.setParameters(idHabitacion, nombre, tipoHabitacion, numeroHabitacion, idEmpleado);
        return (long) q.executeUnique();
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE id = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}

	public long eliminarHabitacionPorId (PersistenceManager pm, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacion () + " WHERE id = ?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionPorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacion () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionPorTipo (PersistenceManager pm, String tipoHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacion () + " WHERE tipo = ?");
        q.setParameters(tipoHabitacion);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionPorNumero (PersistenceManager pm, long numeroHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacion () + " WHERE numero = ?");
        q.setParameters(numeroHabitacion);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionPorIdEmpleado (PersistenceManager pm, long idEmpleado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacion () + " WHERE numero = ?");
        q.setParameters(idEmpleado);
        return (long) q.executeUnique();            
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, String id, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE idHabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeList();
	}
	
	public List<Habitacion> darHabitacionPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE nombre = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(nombre);
		return (List<Habitacion>) q.executeList();
	}
	
	public List<Habitacion> darHabitacionPorTipo (PersistenceManager pm, String tipoHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE tipoHabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(tipoHabitacion);
		return (List<Habitacion>) q.executeList();
	}
	
	public List<Habitacion> darHabitacionPorNumero (PersistenceManager pm, String numero) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE numero = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(numero);
		return (List<Habitacion>) q.executeList();
	}

	public List<Habitacion> darHabitacionPorIdEmpleado (PersistenceManager pm, long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion () + " WHERE idEmpleado = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idEmpleado);
		return (List<Habitacion>) q.executeList();
	}
	
	
	public List<Habitacion> darHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion ());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

	public List<Habitacion> darHabitacionesNoReservadas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacion()+" h,"+ph.darTablaHabitacionReservada()+" hr WHERE h.idHabitacion <> hr.idHabitacion");
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

}
