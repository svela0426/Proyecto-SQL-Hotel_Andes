package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Empleado;

public class SQLEmpleado {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLEmpleado (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarEmpleado (PersistenceManager pm, long idEmpleado, String nombre, long celular, String correo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaEmpleado () + "(idEmpleado, nombre, celular, correo) values (?, ?, ?, ?)");
        q.setParameters(idEmpleado, nombre, celular, correo);
        return (long) q.executeUnique();
	}
	
	
	
	public long eliminarEmpleadoPorId (PersistenceManager pm, long idEmpleado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleado () + " WHERE id = ?");
        q.setParameters(idEmpleado);
        return (long) q.executeUnique();            
	}
	
	public long eliminarEmpleadoPorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleado () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	public long eliminarEmpleadoPorCelular (PersistenceManager pm, long celular)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleado () + " WHERE celular = ?");
        q.setParameters(celular);
        return (long) q.executeUnique();            
	}
	
	public long eliminarEmpleadoPorCorreo (PersistenceManager pm, String correo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleado () + " WHERE correo = ?");
        q.setParameters(correo);
        return (long) q.executeUnique();            
	}
	
	public List<Empleado> darEmpleado (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  ph.darTablaEmpleado ());
		q.setResultClass(Empleado.class);
		return (List<Empleado>) q.executeList();
	}
	
	public List<Empleado> darEmpleadoPorId (PersistenceManager pm, long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado () + " WHERE id = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(idEmpleado);
		return (List<Empleado>) q.executeList();
	}
	
	public List<Empleado> darEmpleadoPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado () + " WHERE nombre = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(nombre);
		return (List<Empleado>) q.executeList();
	}
	
	public List<Empleado> darEmpleadoPorCelular (PersistenceManager pm, long celular) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado () + " WHERE celular = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(celular);
		return (List<Empleado>) q.executeList();
	}
	
	public List<Empleado> darEmpleadoPorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado () + " WHERE correo = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(correo);
		return (List<Empleado>) q.executeList();
	}
	
}
