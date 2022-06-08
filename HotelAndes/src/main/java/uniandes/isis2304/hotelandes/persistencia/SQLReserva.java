package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Reserva;

public class SQLReserva {
	
	
	
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLReserva (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarReserva (PersistenceManager pm, long idReserva, Timestamp fechaEntrada, Timestamp fechaSalida, BigDecimal numeroPersonas, BigDecimal idCliente, BigDecimal plan_de_pago,String estado) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva() + "(idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado) values (?, ?, ?, ?, ?,?,?)");
	        q.setParameters(idReserva, fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago,estado);
	        return (long) q.executeUnique();		
	}

	public long liberarReserva (PersistenceManager pm, BigDecimal idReserva) 
	{
		
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva() + " SET estado = ? WHERE idReserva = ? ");
	        q.setParameters("Pasada", idReserva);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarReservasPorEstado (PersistenceManager pm, String estado)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE estado = ?");
        q.setParameters(estado);
        return (long) q.executeUnique();		
	}
	
	public long eliminarReservasPorplan_de_pago (PersistenceManager pm, int plan_de_pago)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE plan_de_pago = ?");
        q.setParameters(plan_de_pago);
        return (long) q.executeUnique();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public long eliminarReservasPorIdcliente (PersistenceManager pm, long idCliente)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE idCliente = ?");
        q.setParameters(idCliente);
        return (long) q.executeUnique();		
	}
	
	public List<Reserva> darReservasPorestado(PersistenceManager pm, String estado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE estado = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(estado);
		return ( List<Reserva>) q.executeList();
	}
	
	
	
	
	
	
	public long eliminaReservaPorId (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();
	}
	
	
	public Reserva darReservaPorId (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE idReserva = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idReserva);
		return (Reserva) q.executeUnique();
	}
	
	public List<Reserva> darReservasPorIdcliente (PersistenceManager pm, long idCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE idCliente = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idCliente);
		return ( List<Reserva>) q.executeList();
	}

	public List<Reserva> darReservasPorIdPlanPago (PersistenceManager pm, BigDecimal idPlanPago) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE plan_de_pago = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idPlanPago);
		return ( List<Reserva>) q.executeList();
	}
	
	public  List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel ());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}
	
	
	
	public long aumentarNumeroPersonasReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHotel () + " SET numeroPersonas = numeroPersonas + 1 WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();
	}
	
	
	
	
	
	

}
