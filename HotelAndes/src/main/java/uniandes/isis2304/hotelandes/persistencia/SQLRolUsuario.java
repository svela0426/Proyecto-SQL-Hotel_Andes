package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.RolUsuario;

public class SQLRolUsuario  {
	
	

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	public SQLRolUsuario (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarRolUsuario (PersistenceManager pm, BigDecimal numero_documento, String rol) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRolUsuario()  + "(numero_documento, rol) values (?, ?)");
	        q.setParameters(numero_documento, rol);
	        return (long) q.executeUnique();		
	}
	
	
	
	public long eliminarRolUsuario (PersistenceManager pm,  long numero_documento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRolUsuario () + " WHERE numero_documento = ?");
        q.setParameters(numero_documento);
        return (long) q.executeUnique();
	}

	public RolUsuario darRolUsuarioPorNumeroDocumento (PersistenceManager pm, long numero_documento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRolUsuario()+ "WHERE numero_documento = ?");
		q.setResultClass(RolUsuario.class);
		RolUsuario resp = (RolUsuario) q.execute();
		return resp;
	}
	
	
	public List<RolUsuario> darRolesUsuario (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRolUsuario ());
		q.setResultClass(RolUsuario.class);
		List<RolUsuario> resp = (List<RolUsuario>) q.execute();
		return resp;
	}
	
	

}
