package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TipoReserva;

public class SQLTipoReserva  {
	
	

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	public SQLTipoReserva (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarTipoReserva (PersistenceManager pm, long idReserva, long idPlanConsumo) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTipoReserva()  + "(idReserva, idPlanConsumo) values (?, ?)");
	        q.setParameters(idReserva, idPlanConsumo);
	        return (long) q.executeUnique();		
	}
	
	
	
	public long eliminarTipoReserva (PersistenceManager pm,  long idReserva, long idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoReserva () + " WHERE idReserva = ? AND idPlanConsumo = ?");
        q.setParameters(idReserva, idPlanConsumo);
        return (long) q.executeUnique();
	}
	
	
	public List<TipoReserva> darTipoReserva (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoReserva ());
		q.setResultClass(TipoReserva.class);
		List<TipoReserva> resp = (List<TipoReserva>) q.execute();
		return resp;
	}
	
	

}
