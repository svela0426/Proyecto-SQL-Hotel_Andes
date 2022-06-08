package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;

public class SQLTipo_Habitacion {
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLTipo_Habitacion (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarTipo_Habitacion (PersistenceManager pm, String tipoHabitacion, BigDecimal capacidad, BigDecimal area) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTipoHabitacion()  + "(tipoHabitacion, capacidad, area) values (?, ?, ?)");
	        q.setParameters(tipoHabitacion, capacidad, area);
	        return (long) q.executeUnique();		
	}
	
	public TipoHabitacion darTipo_HabitacionPortipoHabitacion (PersistenceManager pm, String tipoHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion () + " WHERE tipoHabitacion = ?");
		q.setResultClass(TipoHabitacion.class);
		q.setParameters(tipoHabitacion);
		return (TipoHabitacion) q.executeUnique();
	}
	
	
	
	public long eliminarTipo_Habitacion (PersistenceManager pm, String tipoHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion () + " WHERE tipoHabitacion = ? ");
        q.setParameters(tipoHabitacion);
        return (long) q.executeUnique();
	}
	
	
	public List<TipoHabitacion> darTipo_Habitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion ());
		q.setResultClass(TipoHabitacion.class);
		List<TipoHabitacion> resp = (List<TipoHabitacion>) q.execute();
		return resp;
	}
	
	
	

}
