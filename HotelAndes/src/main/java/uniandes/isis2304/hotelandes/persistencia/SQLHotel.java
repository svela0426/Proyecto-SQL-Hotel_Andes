package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Hotel;

public class SQLHotel 
{
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLHotel (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

	
	
	
	
	public long adicionarHotel (PersistenceManager pm, long idHotel, String nombre, String ubicacion, String paginaweb, long numero) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHotel()  + "(idHotel, nombre, ubicacion, paginaweb, numero) values (?, ?, ?, ?, ?)");
	        q.setParameters(idHotel, nombre, ubicacion, paginaweb, numero);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarHotelPorNombre (PersistenceManager pm, String nombre)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();		
	}
	
	public long eliminaHotelPorId (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();
	}
	
	public Hotel darHotelPorId (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE idHotel = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}
	
	
	public List<Hotel> darHotelesPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE nombre = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(nombre);
		return ( List<Hotel>) q.executeList();
	}
	
	public  List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel ());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
	
	

	
	
	

	
	

	
	
	
	
	
	
	

}
