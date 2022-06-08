package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.HabitacionReservada;

public class SQLHabitacionReservada {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLHabitacionReservada (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarHabitacionReservada (PersistenceManager pm, BigDecimal idHabitacion, BigDecimal idReserva, BigDecimal idCuenta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaHabitacionOfertada () + "(idHabitacion, idReserva, idCuenta) values (?, ?, ?)");
        q.setParameters(idHabitacion, idReserva, idCuenta);
        return (long) q.executeUnique();
	}
	
	public List<HabitacionReservada> darHabitacionReservadaPorId (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idReserva = ?");
		q.setResultClass(HabitacionReservada.class);
		return (List<HabitacionReservada>) q.executeList();
	}
	
	public long eliminarHabitacionReservadaPorId (PersistenceManager pm, BigDecimal idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHabitacion = ?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionReservadaPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacionOfertada () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public long eliminarHabitacionReservadaPorIdCuenta (PersistenceManager pm, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaHabitacionOfertada () + " WHERE idCuenta = ?");
        q.setParameters(idCuenta);
        return (long) q.executeUnique();            
	}
	
	public List<HabitacionReservada> darHabitacionReservadaPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idReserva = ?");
		q.setResultClass(HabitacionReservada.class);
		q.setParameters(idReserva);
		return (List<HabitacionReservada>) q.executeUnique();
	}

	public List<HabitacionReservada> darHabitacionReservada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada ());
		q.setResultClass(HabitacionReservada.class);
		return (List<HabitacionReservada>) q.executeList();

	}
	
	public List<HabitacionReservada> darHabitacionReservadaPorIdCuenta (PersistenceManager pm, long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idHabitacion = ?");
		q.setResultClass(HabitacionReservada.class);
		q.setParameters(idHabitacion);
		return (List<HabitacionReservada>) q.executeList();
	}
	
	public List<HabitacionReservada> darHabitacionReservada (PersistenceManager pm, long idReserva)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaHabitacionOfertada () + " WHERE idReserva = ?");
		q.setResultClass(HabitacionReservada.class);
		q.setParameters(idReserva);
		return (List<HabitacionReservada>) q.executeList();
	}

}
