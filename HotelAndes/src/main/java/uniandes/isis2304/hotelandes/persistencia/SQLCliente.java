package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Cliente;


public class SQLCliente {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	
	public SQLCliente (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	
	
	public long adicionarCliente (PersistenceManager pm, BigDecimal idUsuario,BigDecimal idMetodoPago,BigDecimal idHotel,BigDecimal plandepago) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaCliente  () + "(id, metodoPago, hotelPerteneciente, idplanpago) values (?, ?, ?, ?)");
        q.setParameters(idUsuario, idMetodoPago, idHotel, plandepago);
        return (long) q.executeUnique();
	}
	
	

	public long eliminarClientePorId (PersistenceManager pm, long idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCliente () + " WHERE id = ?");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();            
	}
	
	public long eliminarClientePorMetodoPago (PersistenceManager pm, long idMetodoPago)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCliente () + " WHERE metodoPago = ?");
        q.setParameters(idMetodoPago);
        return (long) q.executeUnique();            
	}
	
	public long eliminarClientePorHotel (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCliente () + " WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();            
	}
	
	public long eliminarEmpleadoporPlandepago (PersistenceManager pm, long plandepago)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCliente () + " WHERE plandepago = ?");
        q.setParameters(plandepago);
        return (long) q.executeUnique();            
	}
	
	public List<Cliente> darClientes (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  ph.darTablaCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}
	
	public Cliente darClientePorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCliente () + " WHERE idUsuario = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(idUsuario);
		return (Cliente) q.executeList();
	}
	
	public List<Cliente> darClientePorMetodoPago (PersistenceManager pm, long idMetodoPago) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCliente () + " WHERE idMetodoPago = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(idMetodoPago);
		return (List<Cliente>) q.executeList();
	}
	
	public List<Cliente> darClientePorHotel (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCliente () + " WHERE idHotel = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(idHotel);
		return (List<Cliente>) q.executeList();
	}
	
	public List<Cliente> darClientePorPlandepago (PersistenceManager pm, BigDecimal plandepago) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCliente () + " WHERE plandepago = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(plandepago);
		return (List<Cliente>) q.executeList();
	}
	

	
	
	
	
	
	
	
	
	

}

