package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ServicioSolicitado;

public class SQLServicio_Solicitado {
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLServicio_Solicitado (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicio_Solicitado (PersistenceManager pm, BigDecimal idServicio, BigDecimal numpersonas, BigDecimal Costo,Timestamp fecha_solicitud) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioSolicitado()  + "(idServicio, numpersonas, Costo,fecha_solicitud) values (?, ?,?, ?)");
	        q.setParameters(idServicio, numpersonas, Costo,fecha_solicitud);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarServicio_SolicitadoPorId (PersistenceManager pm, long idServicio) 
	{	
		 Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioSolicitado () + " WHERE idServicio = ?");
	        q.setParameters(idServicio);
	        return (long) q.executeUnique(); 		
	}
	
	
	public ServicioSolicitado  darServicio_SolicitadopoID (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSolicitado () + " WHERE id = ?");
		q.setResultClass(ServicioSolicitado.class);
		q.setParameters(idServicio);
		return (ServicioSolicitado) q.executeUnique();
	}
	
	public List<ServicioSolicitado>  darServicio_Solicitadoporfecha_solicitud (PersistenceManager pm, Timestamp fecha_solicitud) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE idCliente = ?");
		q.setResultClass(ServicioSolicitado.class);
		q.setParameters(fecha_solicitud);
		return ( List<ServicioSolicitado>) q.executeList();
	}
	
	
	
	
	
	
	public  List<ServicioSolicitado> darServicio_Solicitado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioSolicitado ());
		q.setResultClass(ServicioSolicitado.class);
		return (List<ServicioSolicitado> ) q.executeList();
	}
	
	
	
	public long aumentarnumeroPersonasServicio_SolicitadoID (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicioSolicitado () + " SET numpersonas = numpersonas + 1 WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
	}
	
	

	
	
	

}
