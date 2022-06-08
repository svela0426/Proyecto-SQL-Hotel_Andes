package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.CuentaCargada;

public class SQLCuentaCargada {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLCuentaCargada (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarCuentaCargada (PersistenceManager pm, long idCuenta, long idServicio) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaCuentaCargada () + "(idCuenta, idServicio) values (?, ?)");
        q.setParameters(idCuenta, idServicio);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarCuentaCargada (PersistenceManager pm, long idCuenta, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaCuentaCargada () + " WHERE idCuenta = ? AND idServicio = ?");
        q.setParameters(idCuenta, idServicio);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los GUSTAN de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos GUSTAN
	 */
	public List<CuentaCargada> darCuentaCargada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaCuentaCargada ());
		q.setResultClass(CuentaCargada.class);
		List<CuentaCargada> resp = (List<CuentaCargada>) q.execute();
		return resp;
	}
	
	
}