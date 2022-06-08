package uniandes.isis2304.hotelandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.PlanDePagoAcordado;

public class SQLPlanDePagoAcordado {
	
	
	
private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLPlanDePagoAcordado (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	public long adicionarPlanDePagoAcordado (PersistenceManager pm, long id, String tipoHabitaciones, int numeroHabitaciones,  int numeroPersonas, Timestamp fechaInicio, Timestamp fechaSalida, String estado) 
	{
		
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanDePagoAcordado() + "(id, tipoHabitaciones, numeroHabitaciones, numeroPersonas, fechaInicio, fechaSalida,estado) values (?,  ?, ?, ?,?,?,?)");
	        q.setParameters(id, tipoHabitaciones, numeroHabitaciones, numeroPersonas, fechaInicio, fechaSalida,estado);
	        return (long) q.executeUnique();		
	}
	
	
	public long eliminarPlanDePagoAcordadosPorEstado (PersistenceManager pm, String estado)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE estado = ?");
        q.setParameters(estado);
        return (long) q.executeUnique();		
	}
	
	public long eliminarPlanDePagoAcordadosPorTipoHabitacion (PersistenceManager pm, String tipoHabitacion)
	{	
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE tipo_habitaciones = ?");
        q.setParameters(tipoHabitacion);
        return (long) q.executeUnique();		
	}

    public List<PlanDePagoAcordado> darPlanDePagoAcordadoPorTipoHabitacion (PersistenceManager pm, String tipoHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE tipo_habitaciones = ?");
		q.setResultClass(PlanDePagoAcordado.class);
		q.setParameters(tipoHabitacion);
		return ( List<PlanDePagoAcordado>) q.executeList();
	}
	
	public List<PlanDePagoAcordado> darPlanDePagoAcordadosPorestado(PersistenceManager pm, String estado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE estado = ?");
		q.setResultClass(PlanDePagoAcordado.class);
		q.setParameters(estado);
		return ( List<PlanDePagoAcordado>) q.executeList();
	}
	
	
	public long eliminaPlanDePagoAcordadoPorId (PersistenceManager pm, long idPlanDePagoAcordado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE idPlanDePagoAcordado = ?");
        q.setParameters(idPlanDePagoAcordado);
        return (long) q.executeUnique();
	}
	
	
	public PlanDePagoAcordado darPlanDePagoAcordadoPorId (PersistenceManager pm, long idPlanDePagoAcordado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDePagoAcordado () + " WHERE idPlanDePagoAcordado = ?");
		q.setResultClass(PlanDePagoAcordado.class);
		q.setParameters(idPlanDePagoAcordado);
		return (PlanDePagoAcordado) q.executeUnique();
	}
	
	public  List<PlanDePagoAcordado> darPlanDePagoAcordados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanDePagoAcordado());
		q.setResultClass(PlanDePagoAcordado.class);
		return (List<PlanDePagoAcordado>) q.executeList();
	}

}
