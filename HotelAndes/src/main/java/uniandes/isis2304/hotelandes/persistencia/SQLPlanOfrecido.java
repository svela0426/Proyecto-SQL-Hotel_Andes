package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.PlanOfrecido;

public class SQLPlanOfrecido {
	
	

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLPlanOfrecido (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarPlanOfrecido (PersistenceManager pm, long idPlanConsumo, long idHotel) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanOfrecido()  + "(idPlanConsumo, idHotel) values (?, ?)");
	        q.setParameters(idPlanConsumo, idHotel);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarPlanOfrecido (PersistenceManager pm, long idPlanConsumo, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanOfrecido () + " WHERE idPlanConsumo = ? AND idHotel = ?");
        q.setParameters(idPlanConsumo, idHotel);
        return (long) q.executeUnique();
	}
	
	
	public List<PlanOfrecido > darPlanOfrecidos  (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanOfrecido ());
		q.setResultClass(PlanOfrecido.class);
		List<PlanOfrecido> resp = (List<PlanOfrecido>) q.execute();
		return resp;
	}
	
	
	
	
	
	

}
