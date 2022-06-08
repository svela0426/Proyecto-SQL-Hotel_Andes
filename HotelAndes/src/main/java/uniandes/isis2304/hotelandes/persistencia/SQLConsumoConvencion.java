package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ConsumoConvencion;
import uniandes.isis2304.hotelandes.negocio.Hotel;

public class SQLConsumoConvencion {
	
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLConsumoConvencion (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarConsumoConvencion (PersistenceManager pm, long idPlandePago,String servicioSolicitado, int capacidad,int precio) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darConsumoConvencion()  + "(idPlandePago, servicioSolicitado, capacidad,precio) values (?, ?, ?,?)");
	        q.setParameters(idPlandePago, servicioSolicitado, capacidad,precio);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarConsumoConvencionporPlandePago (PersistenceManager pm, long idPlandePago)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darConsumoConvencion () + " WHERE idPlandePago = ?");
        q.setParameters(idPlandePago);
        return (long) q.executeUnique();		
	}
	
	
	public long eliminarConsumoConvencionporServicioSolicitado (PersistenceManager pm, String servicioSolicitado)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darConsumoConvencion () + " WHERE servicioSolicitado = ?");
        q.setParameters(servicioSolicitado);
        return (long) q.executeUnique();		
	}
	
	public ConsumoConvencion darConsumoConvencionporServicioPorPlandePago (PersistenceManager pm, long idPlandePago) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darConsumoConvencion () + " WHERE idPlandePago = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idPlandePago);
		return (ConsumoConvencion) q.executeUnique();
	}
	
	
	public List<ConsumoConvencion> darConsumoConvencionPorservicio (PersistenceManager pm, String servicioSolicitado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darConsumoConvencion () + " WHERE servicioSolicitado = ?");
		q.setResultClass(ConsumoConvencion.class);
		q.setParameters(servicioSolicitado);
		return ( List<ConsumoConvencion>) q.executeList();
	}
	
	
	public  List<ConsumoConvencion> darConsumoConvenciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darConsumoConvencion ());
		q.setResultClass(ConsumoConvencion.class);
		return (List<ConsumoConvencion>) q.executeList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
