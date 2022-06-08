package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;





public class SQLUtil {
	
	
	
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	
	
	private PersistenciaHotelAndes pp;
	
	
	
	public SQLUtil (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

        public List<String> consulta1(PersistenceManager pm, String fechaInicio, String fechaFin){
                Query q = pm.newQuery(SQL, "SELECT h.NUMEROHABITACION, c.TOTAL FROM a_habitacion h, a_habitacion_reservada hr, a_cuenta c, a_reserva r WHERE h.idHabitacion = hr.idHabitacion AND hr.idCuenta = c.idCuenta AND r.fechaEntrada BETWEEN ? AND ? AND r.fechasalida BETWEEN ? AND ?;");
                q.setClass(String.class);
                q.setParameters(fechaInicio, fechaFin);
                return (List<String>) q.executeList();
        }
	
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqHotelAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	
	
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente ());          
        Query qClienteActivo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaClienteActivo());
        Query qCuenta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuenta());
        Query qCuentaCargada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuentaCargada());
        Query qEmpleado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpleado());
        Query qEmpleadoActivo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpleadoActivo());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion());
        Query qHabitacionOfertada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionOfertada());
        Query qHabitacionReservada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionReservada());
        Query qHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel());
        Query qMetodoPago = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMetodoPago());
        Query qPlanDeConsumo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanDeConsumo());
        Query qPlanOfrecido = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanOfrecido());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva());
        Query qServicio_Solicitado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioSolicitado());
        Query qServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qServicioOfrecido = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanOfrecido());
        Query qTipo_Habitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion());
        Query qTipoReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoReserva());


        long ClienteEliminados = (long) qCliente.executeUnique ();
        long ClienteActivoEliminados = (long) qClienteActivo.executeUnique ();
        long CuentaEliminadas = (long) qCuenta.executeUnique ();
        long CuentaCargadaEliminadas = (long) qCuentaCargada.executeUnique ();
        long EmpleadoEliminadas = (long) qEmpleado.executeUnique ();
        long EmpleadoActivoEliminadas = (long) qEmpleadoActivo.executeUnique ();
        long HabitacionEliminadas = (long) qHabitacion.executeUnique ();
        long HabitacionOfertadaEliminadas = (long) qHabitacionOfertada.executeUnique ();
        long HabitacionReservadaEliminadas = (long) qHabitacionReservada.executeUnique ();
        long HotelEliminadas = (long) qHotel.executeUnique ();
        long MetodoPagoEliminadas = (long) qMetodoPago.executeUnique ();
        long PlanDeConsumoEliminadas = (long) qPlanDeConsumo.executeUnique ();
        long PlanOfrecidoEliminadas = (long) qPlanOfrecido.executeUnique ();
        long ReservaEliminadas = (long) qReserva.executeUnique ();
        long Servicio_SolicitadoEliminadas = (long) qServicio_Solicitado.executeUnique ();
        long ServicioEliminadas = (long) qServicio.executeUnique ();
        long ServicioOfrecidoEliminadas = (long) qServicioOfrecido.executeUnique ();
        long Tipo_HabitacionEliminadas = (long) qTipo_Habitacion.executeUnique ();
        long TipoReservaEliminadas = (long) qTipoReserva.executeUnique ();

        
       
        
        
        return new long[] {ClienteEliminados,ClienteActivoEliminados,CuentaEliminadas, CuentaCargadaEliminadas,
        		EmpleadoEliminadas,EmpleadoActivoEliminadas,HabitacionEliminadas,HabitacionOfertadaEliminadas,
        		HabitacionReservadaEliminadas,HotelEliminadas,MetodoPagoEliminadas,PlanDeConsumoEliminadas,
        		PlanOfrecidoEliminadas,ReservaEliminadas,Servicio_SolicitadoEliminadas,ServicioEliminadas,
        		ServicioOfrecidoEliminadas,Tipo_HabitacionEliminadas,TipoReservaEliminadas};
	}

	
	
	
	
	

}
