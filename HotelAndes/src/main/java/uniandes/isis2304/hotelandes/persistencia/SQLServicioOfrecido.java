package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ServicioOfrecido;

public class SQLServicioOfrecido {
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	
	public SQLServicioOfrecido (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicioOfrecido    (PersistenceManager pm, long idServicio, long idHotel) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio()  + "(idServicio, idHotel) values (?, ?)");
	        q.setParameters(idServicio, idHotel);
	        return (long) q.executeUnique();		
	}
	
	
	
	public long eliminarServicioOfrecido  (PersistenceManager pm, long idServicio, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE idServicio = ? AND idHotel = ?");
        q.setParameters(idServicio, idHotel);
        return (long) q.executeUnique();
	}
	
	
	
	public List<ServicioOfrecido> darServicioOfrecido (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio ());
		q.setResultClass(ServicioOfrecido.class);
		List<ServicioOfrecido> resp = (List<ServicioOfrecido>) q.execute();
		return resp;
	}

}
