package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Cuenta;

public class SQLCuenta {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLCuenta (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarCuenta (PersistenceManager pm, BigDecimal idCuenta, BigDecimal total) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaCuenta () + "(idCuenta, total) values (?, ?)");
        q.setParameters(idCuenta, total);
        return (long) q.executeUnique();
	}
	
	public List<Cuenta> darCuentaPorId (PersistenceManager pm, long idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCuenta () + " WHERE id = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(idCuenta);
		return (List<Cuenta>) q.executeList();
	}
	
	public long eliminarCuentaPorId (PersistenceManager pm, long idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCuenta () + " WHERE idCuenta = ?");
        q.setParameters(idCuenta);
        return (long) q.executeUnique();            
	}
	
	public long eliminarCuentaPorTotal (PersistenceManager pm, long total)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCuenta () + " WHERE total = ?");
        q.setParameters(total);
        return (long) q.executeUnique();            
	}
	
	public Cuenta darCuenta (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCuenta () + " WHERE id = ?");
		q.setResultClass(Cuenta.class);
		return (Cuenta) q.executeUnique();
	}
	
	
	public  List<Cuenta> darCuentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " +  ph.darTablaCuenta ());
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}
}

