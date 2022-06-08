package uniandes.isis2304.hotelandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.PlanDeConsumo;

public class SQLPlanDeConsumo {
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	public SQLPlanDeConsumo (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarPlanDeConsumo (PersistenceManager pm, long idPlanConsumo, String nombre, int costo, Timestamp vigencia) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanDeConsumo()  + "(idPlanConsumo, nombre, costo, vigencia) values (?, ?, ?, ?)");
	        q.setParameters(idPlanConsumo, nombre, costo, vigencia);
	        return (long) q.executeUnique();		
	}
	
	
	
	public long eliminarPlanDeConsumoPorNombre (PersistenceManager pm, String nombre)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDeConsumo () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();		
	}
	
	
	public long eliminaPlanDeConsumoPorId (PersistenceManager pm, long idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDeConsumo () + " WHERE idPlanConsumo = ?");
        q.setParameters(idPlanConsumo);
        return (long) q.executeUnique();
	}
	
	public PlanDeConsumo darPlanDeConsumoPorId (PersistenceManager pm, long idPlanConsumo ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDeConsumo () + " WHERE idPlanConsumo = ?");
		q.setResultClass(PlanDeConsumo.class);
		q.setParameters(idPlanConsumo);
		return (PlanDeConsumo) q.executeUnique();
	}
	
	
	public List<PlanDeConsumo> darPlanDeConsumosPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDeConsumo () + " WHERE nombre = ?");
		q.setResultClass(PlanDeConsumo.class);
		q.setParameters(nombre);
		return ( List<PlanDeConsumo>) q.executeList();
	}
	
	public  List<PlanDeConsumo> darPlanDeConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDeConsumo ());
		q.setResultClass(PlanDeConsumo.class);
		return (List<PlanDeConsumo>) q.executeList();
	}
	
	
	
	
	
	
	
	

}
