package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.EmpleadoActivo;

public class SQLEmpleadoActivo {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLEmpleadoActivo (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarEmpleado (PersistenceManager pm, long idHotel, long idEmpleado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaEmpleadoActivo () + "(idHotel, idEmpleado) values (?, ?)");
        q.setParameters(idHotel, idEmpleado);
        return (long) q.executeUnique();
	}
	
	public long eliminarEmpleadoActivoPorId (PersistenceManager pm, long idEmpleado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleadoActivo () + " WHERE idEmpleado = ?");
        q.setParameters(idEmpleado);
        return (long) q.executeUnique();            
	}

	public long eliminarEmpleadoActivoPorIdHotel (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaEmpleadoActivo () + " WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();            
	}
	
	public List<EmpleadoActivo> darEmpleadoActivo (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado ());
		q.setResultClass(EmpleadoActivo.class);
		return (List<EmpleadoActivo>) q.executeList();
	}
	
	public  EmpleadoActivo darEmpleadoActivoPorId (PersistenceManager pm, long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleado () + " WHERE idEmpleado = ?");
		q.setResultClass(EmpleadoActivo.class);
		q.setParameters(idEmpleado);
		return (EmpleadoActivo) q.executeUnique();
	}
	
	public List<EmpleadoActivo> darEmpleadoActivoPorIdHotel (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleadoActivo () + " WHERE idHotel = ?");
		q.setResultClass(EmpleadoActivo.class);
		q.setParameters(idHotel);
		return (List<EmpleadoActivo>) q.executeList();
	}
	
	public List<EmpleadoActivo> darEmpleado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaEmpleadoActivo ());
		q.setResultClass(EmpleadoActivo.class);
		return (List<EmpleadoActivo>) q.executeList();
	}
}
