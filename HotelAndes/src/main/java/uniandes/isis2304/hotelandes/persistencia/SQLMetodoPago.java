package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.MetododePago;

public class SQLMetodoPago 
{
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLMetodoPago (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarMetodopago (PersistenceManager pm, long idMetodoPago, String tipo, String nombre) 
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMetodoPago()  + "(idMetodoPago, tipo, nombre) values (?, ?, ?)");
	        q.setParameters(idMetodoPago,tipo, nombre);
	        return (long) q.executeUnique();		
	}
	
	public long eliminarMetodopagoPorNombre (PersistenceManager pm, String nombre)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMetodoPago () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();		
	}
	
	public long eliminaMetodopagoPorId (PersistenceManager pm, long idMetodoPago)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMetodoPago () + " WHERE idMetodoPago = ?");
        q.setParameters(idMetodoPago);
        return (long) q.executeUnique();
	}
	
	public MetododePago daMetodopagoPorId (PersistenceManager pm, long idMetodoPago) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE idMetodoPago = ?");
		q.setResultClass(MetododePago.class);
		q.setParameters(idMetodoPago);
		return (MetododePago) q.executeUnique();
	}
	
	public MetododePago darMetododePagoPorNombre (PersistenceManager pm, String nombre) 
	{

		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE nombre = ?");
		q.setResultClass(MetododePago.class);
		q.setParameters(nombre);
		return (MetododePago) q.executeUnique();
	}
	
	
	public List<MetododePago> darMetododePagos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel ());
		q.setResultClass(MetododePago.class);
		return (List<MetododePago>) q.executeList();
	}
	
	
	
	
	
	
	

}
