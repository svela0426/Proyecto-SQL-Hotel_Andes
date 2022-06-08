package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.OrganizadorEventos;

public class SQLOrganizadorEventos  {
	
	

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	public SQLOrganizadorEventos (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarOrganizadorEventos (PersistenceManager pm, BigDecimal numero_documento, BigDecimal planDePagoAcordado) 
	{
		
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrganizadorEventos()  + "(numero_documento, planDePagoAcordado) values (?, ?)");
		q.setParameters(numero_documento, planDePagoAcordado);
		return (long) q.executeUnique();		
	}
	
	
	
	public long eliminarOrganizadorEventos (PersistenceManager pm,  long numero_documento, long planDePagoAcordado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrganizadorEventos () + " WHERE numero_documento = ? AND planDePagoAcordado = ?");
        q.setParameters(numero_documento, planDePagoAcordado);
        return (long) q.executeUnique();
	}
	
	
	public List<OrganizadorEventos> darOrganizadorEventos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrganizadorEventos ());
		q.setResultClass(OrganizadorEventos.class);
		List<OrganizadorEventos> resp = (List<OrganizadorEventos>) q.execute();
		return resp;
	}
	
	

}
