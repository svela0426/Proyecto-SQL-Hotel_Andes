package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Servicio;

public class SQLServicio {
	
	
	
	
	

	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLServicio (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarServicio (PersistenceManager pm, BigDecimal idServicio, String nombre, String descripcion, BigDecimal area, BigDecimal costo) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio()  + "(idServicio, nombre, descripcion, area, costo) values (?, ?, ?, ?, ?)");
	        q.setParameters(idServicio, nombre, descripcion, area, costo);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarServicioPorNombre (PersistenceManager pm, String nombre)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();		
	}
	
	
	
	public long eliminaServicioPorId (PersistenceManager pm, BigDecimal idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
	}
	
	
	public List<Servicio> darServicioPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE nombre = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(nombre);
		return ( List<Servicio>) q.executeList();
	}
	
	
	public  List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}


	/*************************************************
	*Requerimientos funcionales de consulta
	***************************************************/

	//RFC2
	/*
	public List<Servicio> dar20ServiciosPopulares(){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	*/
	
	
	

}
