package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ClienteActivo;

public class SQLClienteActivo {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;


	public SQLClienteActivo (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarClienteActivo (PersistenceManager pm, BigDecimal idCliente, BigDecimal idReserva) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaClienteActivo () + "(idCliente, idReserva) values (?, ?)");
        q.setParameters(idCliente, idReserva);
        return (long) q.executeUnique();
}
	
	
	
	public long eliminarClienteActivo (PersistenceManager pm, BigDecimal idCliente, BigDecimal idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaClienteActivo () + " WHERE idCliente = ? AND idReserva = ?");
        q.setParameters(idCliente, idReserva);
        return (long) q.executeUnique();
	}
	
	public ClienteActivo darReservaPorId (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaClienteActivo () + " WHERE idCliente = ?");
		q.setResultClass(ClienteActivo.class);
		q.setParameters(idReserva);
		return (ClienteActivo) q.executeUnique();
	}

	public long eliminarClienteActivoPorId (PersistenceManager pm, long idCliente)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaClienteActivo () + " WHERE idCliente= ?");
        q.setParameters(idCliente);
        return (long) q.executeUnique();            
	}
	
	public long eliminarClienteActivoPorReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaClienteActivo () + " WHERE idCliente= ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public List<ClienteActivo> darClienteActivo (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaClienteActivo ());
		q.setResultClass(ClienteActivo.class);
		
		return (List<ClienteActivo>) q.executeList();
	}

	public ClienteActivo darClienteActivoPorId (PersistenceManager pm, BigDecimal idCliente)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaClienteActivo () + " WHERE idCliente = ?");
		q.setResultClass(ClienteActivo.class);
		q.setParameters(idCliente);
		return (ClienteActivo) q.executeUnique();
	}
	

	public List<ClienteActivo> darClienteActivoPorReserva (PersistenceManager pm, long idReserva)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaClienteActivo () + " WHERE idCliente = ?");
		q.setResultClass(ClienteActivo.class);
		q.setParameters(idReserva);
		return (List<ClienteActivo>) q.executeList();
	}
	
}