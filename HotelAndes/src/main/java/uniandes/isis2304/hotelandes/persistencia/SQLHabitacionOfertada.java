package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.HabitacionOfertada;

public class SQLHabitacionOfertada {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLHabitacionOfertada (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarHabitacionOfertada (PersistenceManager pm, long idHotel, long idHabitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaHabitacionOfertada () + "(idHotel, idHabitacion) values (?, ?)");
        q.setParameters(idHotel, idHabitacion);
        return (long) q.executeUnique();
	}
	
	public HabitacionOfertada darHabitacionOfertada (PersistenceManager pm, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHabitacion = ?");
		q.setResultClass(HabitacionOfertada.class);
		q.setParameters(idHabitacion);
		return (HabitacionOfertada) q.executeUnique();
	}
	
	public long eliminarHabitacionOfertadaPorIdHotel (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionOfertadaPorId (PersistenceManager pm, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHabitacion = ?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();            
	}
	
	public List<HabitacionOfertada> darHabitacionOfertada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada ());
		q.setResultClass(HabitacionOfertada.class);
		return (List<HabitacionOfertada>) q.executeList();

	}
	
	public List<HabitacionOfertada> darHabitacionOfertadaPorIdHotel (PersistenceManager pm, long idHotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHotel = ?");
		q.setResultClass(HabitacionOfertada.class);
		q.setParameters(idHotel);
		return (List<HabitacionOfertada>) q.executeList();
	}
	
	public List<HabitacionOfertada> darHabitacionOfertadaPorId (PersistenceManager pm, long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHabitacion = ?");
		q.setResultClass(HabitacionOfertada.class);
		q.setParameters(idHabitacion);
		return (List<HabitacionOfertada>) q.executeList();
	}
}


