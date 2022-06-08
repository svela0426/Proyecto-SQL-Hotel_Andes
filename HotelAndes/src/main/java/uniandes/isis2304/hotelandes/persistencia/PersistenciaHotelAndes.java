package uniandes.isis2304.hotelandes.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.hotelandes.negocio.Cliente;
import uniandes.isis2304.hotelandes.negocio.ClienteActivo;
import uniandes.isis2304.hotelandes.negocio.Consulta10;
import uniandes.isis2304.hotelandes.negocio.Consulta12;
import uniandes.isis2304.hotelandes.negocio.Consulta7;
import uniandes.isis2304.hotelandes.negocio.Consulta8;
import uniandes.isis2304.hotelandes.negocio.Consulta9;
import uniandes.isis2304.hotelandes.negocio.ConsumoConvencion;
import uniandes.isis2304.hotelandes.negocio.Cuenta;
import uniandes.isis2304.hotelandes.negocio.CuentaCargada;
import uniandes.isis2304.hotelandes.negocio.Empleado;
import uniandes.isis2304.hotelandes.negocio.EmpleadoActivo;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.HabitacionOfertada;
import uniandes.isis2304.hotelandes.negocio.HabitacionReservada;
import uniandes.isis2304.hotelandes.negocio.Hotel;
import uniandes.isis2304.hotelandes.negocio.MetododePago;
import uniandes.isis2304.hotelandes.negocio.OrganizadorEventos;
import uniandes.isis2304.hotelandes.negocio.PlanDeConsumo;
import uniandes.isis2304.hotelandes.negocio.PlanDePagoAcordado;
import uniandes.isis2304.hotelandes.negocio.PlanOfrecido;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.RolUsuario;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import uniandes.isis2304.hotelandes.negocio.ServicioOfrecido;
import uniandes.isis2304.hotelandes.negocio.ServicioSolicitado;
import uniandes.isis2304.hotelandes.negocio.TipoHabitacion;
import uniandes.isis2304.hotelandes.negocio.TipoReserva;




public class PersistenciaHotelAndes {

	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());

	public final static String SQL = "javax.jdo.query.SQL";

	private static PersistenciaHotelAndes instance;

	private PersistenceManagerFactory pmf;
	
	private SQLUtil sqlUtil;
	
	private SQLCliente sqlCliente;
	
	private SQLConsumoConvencion sqlConsumoConvencion;

	

	private List <String> tablas;
	
	private SQLUsuario sqlUsuario;
	
	private SQLClienteActivo sqlClienteActivo;
	
	private SQLCuentaCargada sqlCuentaCargada;
	
	private SQLCuenta sqlCuenta;
	
	private SQLEmpleado sqlEmpleado;
	
	private SQLEmpleadoActivo sqlEmpleadoActivo;
	
	private SQLHabitacion sqlHabitacion;
	
	private SQLHabitacionOfertada sqlHabitacionOfertada;
	
	private SQLHabitacionReservada sqlHabitacionReservada;
	
	private SQLHotel sqlHotel;
	
	private SQLMetodoPago sqlMetodoPago;
	
	private SQLPlanDeConsumo sqlPlanDeConsumo;
	
	private SQLPlanOfrecido sqlPlanOfrecido;
	
	private SQLReserva sqlReserva;
	
	private SQLServicio_Solicitado sqlServicioSolicitado;
	
	private SQLServicio sqlServicio;
	
	private SQLTipo_Habitacion sqlTipoHabitacion;
	
	private SQLTipoReserva sqlTipoReserva;
	
	private SQLServicioOfrecido  sqlServicioOfrecido;

    private SQLRolUsuario sqlRolUsuario;

    private SQLOrganizadorEventos sqlOrganizadorEventos;

    private SQLPlanDePagoAcordado sqlPlanDePagoAcordado;

    private SQLConsulta7 sqlConsulta7;

    private SQLConsulta8 sqlConsulta8;

    private SQLConsultas sqlConsultas;
	
	
	private PersistenciaHotelAndes () {
		
		pmf = JDOHelper.getPersistenceManagerFactory("ISIS2304A19202210");
		crearClasesSQL ();
	
		tablas = new LinkedList<String> ();
		tablas.add ("hotalandes_sequence");
		tablas.add ("A_USUARIO");		
		tablas.add ("A_CLIENTE_ACTIVO");
		tablas.add ("A_CUENTA");
		tablas.add ("A_CUENTA_CARGADA");
		tablas.add ("A_EMPLEADO");
		tablas.add ("A_EMPLEADO_ACTIVO");
		tablas.add ("A_HABITACION");
		tablas.add ("A_HABITACION_OFERTADA");
		tablas.add ("A_HABITACION_RESERVADA");
		tablas.add ("A_HOTEL");
		tablas.add ("A_METODO_PAGO");
		tablas.add ("A_PLAN_CONSUMO");
		tablas.add ("A_PLAN_OFRECIDO");
		tablas.add ("A_RESERVA");
		tablas.add ("A_SERVICIO");
		tablas.add ("A_SERVICIO_OFRECIDO");
		tablas.add ("A_SERVICIO_SOLICITADO");
		tablas.add ("A_TIPO_HABITACION");
		tablas.add ("A_TIPO_RESERVA");
		tablas.add ("A_CLIENTE");
		tablas.add ("A_CONSUMOCONVENCION");
        tablas.add ("A_ROL_USUARIO");
        tablas.add ("A_ORGANIZADOR_EVENTOS");
        tablas.add ("A_PLAN_DE_PAGO_ACORDADO");


		
		
	}


private PersistenciaHotelAndes (JsonObject tableConfig)
{
	crearClasesSQL ();
	tablas = leerNombreTabla (tableConfig);
	
	String unidadPersistencia = tableConfig.get("unidadPersistencia").getAsString ();
	log.trace ("Acceso a la unidad de persistencia: " + unidadPersistencia);
	pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}











public static PersistenciaHotelAndes getInstance ()
{
	if (instance == null)
	{
		instance = new PersistenciaHotelAndes ();
	}
	return instance;
}

public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
{
	if (instance == null)
	{
		instance = new PersistenciaHotelAndes (tableConfig);
	}
	return instance;
}

public void cerrarUnidadPersistencia ()
{
	pmf.close ();
	instance = null;
}


private List <String> leerNombreTabla (JsonObject tableConfig)
{
	JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

	List <String> resp = new LinkedList <String> ();
	for (JsonElement nom : nombres)
	{
		resp.add (nom.getAsString ());
	}
	
	return resp;
	}

private void crearClasesSQL ()
{
	sqlHotel= new SQLHotel(this);
	sqlUsuario = new SQLUsuario(this);
	sqlPlanDeConsumo = new SQLPlanDeConsumo(this);
	sqlCliente= new SQLCliente(this);
	sqlPlanOfrecido = new SQLPlanOfrecido(this);
	sqlTipoReserva = new SQLTipoReserva(this);
	sqlMetodoPago = new SQLMetodoPago(this);
    sqlReserva = new SQLReserva(this);
    sqlServicio = new SQLServicio(this);
    sqlServicioOfrecido = new SQLServicioOfrecido(this);
    sqlServicioSolicitado = new SQLServicio_Solicitado(this);
    sqlTipoHabitacion = new SQLTipo_Habitacion(this); 
    sqlClienteActivo = new SQLClienteActivo(this);
    sqlCuenta = new SQLCuenta(this);
    sqlCuentaCargada = new SQLCuentaCargada(this);
    sqlEmpleado = new SQLEmpleado(this);
    sqlEmpleadoActivo = new SQLEmpleadoActivo(this);
    sqlHabitacion = new SQLHabitacion(this);
    sqlHabitacionOfertada = new SQLHabitacionOfertada(this);
    sqlHabitacionReservada = new SQLHabitacionReservada(this);
    sqlConsumoConvencion= new SQLConsumoConvencion(this); 
    sqlRolUsuario = new SQLRolUsuario(this);
    sqlOrganizadorEventos = new SQLOrganizadorEventos(this);
    sqlPlanDePagoAcordado = new SQLPlanDePagoAcordado(this);
    sqlUtil = new SQLUtil(this);
    sqlConsulta7 = new SQLConsulta7(this);
    sqlConsulta8 = new SQLConsulta8(this);
    sqlConsultas = new SQLConsultas(this);

	
}	

	public String darSeqHotelAndes () {
	    return tablas.get (0);
	}
	public String darTablaUsuario() {
	    return tablas.get(1);
	}
	public String darTablaClienteActivo() {
	    return tablas.get(2);
	}
	public String darTablaCuenta() {
	    return tablas.get(3);
	}
	public String darTablaCuentaCargada() {
	    return tablas.get(4);
	}
	public String darTablaEmpleado() {
	    return tablas.get(5);
	}
	public String darTablaEmpleadoActivo() {
	    return tablas.get(6);
	}
	public String darTablaHabitacion() {
	    return tablas.get(7);
	}
	public String darTablaHabitacionOfertada() {
	    return tablas.get(8);
	}
	public String darTablaHabitacionReservada() {
	    return tablas.get(9);
	}
	public String darTablaHotel() {
	    return tablas.get(10);
	}
	public String darTablaMetodoPago() {
	    return tablas.get(11);
	}
	public String darTablaPlanDeConsumo() {
	    return tablas.get(12);
	}
	public String darTablaPlanOfrecido() {
	    return tablas.get(13);
	}
	public String darTablaReserva() {
	    return tablas.get(14);
	}
	public String darTablaServicio() {
	    return tablas.get(15);
	}
	public String darTablaServiciOfrecido() {
	    return tablas.get(16);
	}
	public String darTablaServicioSolicitado() {
	    return tablas.get(17);
	}
	public String darTablaTipoHabitacion() {
	    return tablas.get(18);
	}
	public String darTablaTipoReserva() {
	    return tablas.get(19);
	}

	public String darTablaCliente() {
	    return tablas.get(20);
	}
	
	public String darConsumoConvencion() {
	    return tablas.get(21);
	}
	
    public String darTablaRolUsuario() {
	    return tablas.get(22);
	}
    public String darTablaOrganizadorEventos() {
	    return tablas.get(23);
	}
    public String darTablaPlanDePagoAcordado(){
        return tablas.get(24);
    }
  
  
    public List<String> consulta1(String fechaInicio, String fechaFin){
        return sqlUtil.consulta1(pmf.getPersistenceManager(), fechaInicio, fechaFin);
    }

    public List<Consulta7> consulta7(){
        return sqlConsulta7.consulta7(pmf.getPersistenceManager());
    }

    public List<Consulta8> consulta8(){
        return sqlConsulta8.consulta8(pmf.getPersistenceManager());
    }

    public List<Consulta9> consulta9(){
        return sqlConsultas.consulta9(pmf.getPersistenceManager());
    }

    public List<Consulta10> consulta10(){
        return sqlConsultas.consulta10(pmf.getPersistenceManager());
    }

    public List<Consulta12> consulta12(){
        return sqlConsultas.consulta12(pmf.getPersistenceManager());
    }
  

	
	
	private long nextval ()
	{
	    long resp = sqlUtil.nextval (pmf.getPersistenceManager());
	    log.trace ("Generando secuencia: " + resp);
	    return resp;
	}
	
	 
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	
	
	
	
	public ConsumoConvencion adicionarConsumoConvencion (String servicioSolicitado, int capacidad,int precio) 
	{		
		 PersistenceManager pm = pmf.getPersistenceManager();
		    Transaction tx = pm.currentTransaction();
		    try {
		        tx.begin();
		        long idPlandePago = nextval();
		        long tuplasInsertadas = sqlConsumoConvencion.adicionarConsumoConvencion(pm, idPlandePago, servicioSolicitado, capacidad,precio);
		        tx.commit();

		        log.trace("Inserción de : " + idPlandePago + ": " + tuplasInsertadas + " tuplas insertadas");
		    
		        return new ConsumoConvencion (idPlandePago, servicioSolicitado, capacidad,precio);
		    } catch (Exception e) {
		        //e.printStackTrace();
		        log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		        return null;
		    } finally {
		        if (tx.isActive()) {
		            tx.rollback();
		        }
		        pm.close();
		    }       		
	}
	
	
	public long eliminarConsumoConvencionporPlandePago (long idPlandePago)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlConsumoConvencion.eliminarConsumoConvencionporPlandePago(pm, idPlandePago);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
	}
	
	
	public long eliminarConsumoConvencionporServicioSolicitado ( String servicioSolicitado)
	{	
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlConsumoConvencion.eliminarConsumoConvencionporServicioSolicitado(pm, servicioSolicitado);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
	    
	    
	}
	
	public ConsumoConvencion darConsumoConvencionporServicioPorPlandePago ( long idPlandePago) 
	{
		
	    return sqlConsumoConvencion.darConsumoConvencionporServicioPorPlandePago(pmf.getPersistenceManager(), idPlandePago);	
	}
	
	public List<ConsumoConvencion> darConsumoConvencionPorservicio ( String servicioSolicitado) 
	{	
	    return sqlConsumoConvencion.darConsumoConvencionPorservicio(pmf.getPersistenceManager(), servicioSolicitado);	
	}
	
	public List<ConsumoConvencion> darConsumoConvenciones ( ) 
	{	
	    return sqlConsumoConvencion.darConsumoConvenciones(pmf.getPersistenceManager());	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Cliente adicionarCliente (BigDecimal idMetodoPago, BigDecimal idHotel, BigDecimal plandepago) 
	{
		 PersistenceManager pm = pmf.getPersistenceManager();
		    Transaction tx = pm.currentTransaction();
		    try {
		        tx.begin();
		        long idCliente = nextval();
                BigDecimal idClienteBD = new BigDecimal(idCliente);
		        long tuplasInsertadas = sqlCliente.adicionarCliente(pm, idClienteBD, idMetodoPago, idHotel, plandepago);
		        tx.commit();

		        log.trace("Inserción de : " + idCliente + ": " + tuplasInsertadas + " tuplas insertadas");
		    
		        return new Cliente (idClienteBD, idMetodoPago, idHotel, plandepago);
		    } catch (Exception e) {
		        //e.printStackTrace();
		        log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		        return null;
		    } finally {
		        if (tx.isActive()) {
		            tx.rollback();
		        }
		        pm.close();
		    }       
		
	}	
	
	
	
	public long eliminarClientePorId (long idUsuario)
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlCliente.eliminarClientePorId(pm, idUsuario);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
		
	}
	
	
	public long eliminarClientePorMetodoPago ( long idMetodoPago)
	{

		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlCliente.eliminarClientePorMetodoPago(pm, idMetodoPago);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
			
	}
	
	public long eliminarClientePorHotel ( long idHotel)
	{

		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlCliente.eliminarClientePorHotel(pm, idHotel);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
	}
	
	public long eliminarEmpleadoporPlandepago ( long plandepago)
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx=pm.currentTransaction();
	    try
	    {
	        tx.begin();
	        long resp = sqlCliente.eliminarEmpleadoporPlandepago(pm, plandepago);
	        tx.commit();
	        return resp;
	    }
	    catch (Exception e)
	    {
	    	//e.printStackTrace();
	    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        return -1;
	    }
	    finally
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	        pm.close();
	    }
		
	}
	
	
	public List<Cliente> darClientes() {
	    return sqlCliente.darClientes(pmf.getPersistenceManager());
	}

	public Cliente darClientePorId(long idCliente) {
	    return sqlCliente.darClientePorId(pmf.getPersistenceManager(), idCliente);
	}
	
	
	public List<Cliente> darClientePorMetodoPago ( long idMetodoPago) 
	{
	    return sqlCliente.darClientePorMetodoPago(pmf.getPersistenceManager(), idMetodoPago);
	}
	
	public List<Cliente> darClientePorHotel ( long idHotel) 
	{	
	    return sqlCliente.darClientePorHotel(pmf.getPersistenceManager(), idHotel);
	}
	
	public List<Cliente> darClienteporPlandepago (BigDecimal plandepago) 
	{
	    return sqlCliente.darClientePorPlandepago(pmf.getPersistenceManager(), plandepago);

		
	}
	
	



public Usuario adicionarUsuario(BigDecimal numero, String nombre, String apellido, String correo) {
    PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx = pm.currentTransaction();
    try {
        tx.begin();
        long idCliente = nextval();
        BigDecimal idClienteBD = new BigDecimal(idCliente);
        long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, idClienteBD, numero, nombre, apellido, correo);
        tx.commit();

        log.trace("Inserción de : " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
    
        return new Usuario (idClienteBD, numero, nombre, apellido, correo );
    } catch (Exception e) {
        //e.printStackTrace();
        log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return null;
    } finally {
        if (tx.isActive()) {
            tx.rollback();
        }
        pm.close();
    }       
}

public long eliminarUsuarioPorId (long idCliente)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlUsuario.eliminarUsuarioPorId(pm, idCliente);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}

public long eliminarUsuarioPorNumero (long numero)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlUsuario.eliminarUsuarioPorNumero(pm, numero);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}


public long eliminarUsuarioPorNombre (String nombre)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlUsuario.eliminarUsuarioPorNombre(pm, nombre);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}

public long eliminarUsuarioPorApellido (String apellido)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlUsuario.eliminarUsuarioPorApellido(pm, apellido);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}

public long eliminarUsuarioPorCorreo (String correo)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlUsuario.eliminarUsuarioPorCorreo(pm, correo);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}




public List<Usuario> darUsuarios() {
    return sqlUsuario.darUsuarios(pmf.getPersistenceManager());
}

public Usuario darUsuarioPorId(long idCliente) {
    return sqlUsuario.darUsuarioPorId(pmf.getPersistenceManager(), idCliente);
}

public List<Usuario> darUsuarioPorNumero(long numero) {
    return sqlUsuario.darUsuarioPorNumero(pmf.getPersistenceManager(), numero);
}

public List<Usuario> darUsuarioPorNombre(String nombre) {
    return sqlUsuario.darUsuarioPorNombre(pmf.getPersistenceManager(), nombre);
}

public List<Usuario> darUsuarioPorApellido(String apellido) {
    return sqlUsuario.darUsuarioPorApellido(pmf.getPersistenceManager(), apellido);
}









public ClienteActivo adicionarClienteActivo(BigDecimal idCliente, BigDecimal idReserva) {
    PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx = pm.currentTransaction();
    try {
        tx.begin();
        long tuplasInsertadas = sqlClienteActivo.adicionarClienteActivo(pm, idCliente, idReserva);
        tx.commit();

        log.trace("Inserción de : " + idCliente + ": " + tuplasInsertadas + " tuplas insertadas");
    
        return new ClienteActivo(idCliente, idReserva);
    } catch (Exception e) {
        //e.printStackTrace();
        log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return null;
    } finally {
        if (tx.isActive()) {
            tx.rollback();
        }
        pm.close();
    }    
}


public long eliminarClienteActivo(BigDecimal idCliente, BigDecimal idBebida) 
{
	
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlClienteActivo.eliminarClienteActivo(pm, idCliente, idBebida);           
        tx.commit();

        return resp;
    }
    catch (Exception e)
    {
//    	e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
    	return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
	
	
}

public long eliminarClienteActivoPorId (long idCliente)
{
	PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx=pm.currentTransaction();
    try
    {
        tx.begin();
        long resp = sqlClienteActivo.eliminarClienteActivoPorId(pm, idCliente);
        tx.commit();
        return resp;
    }
    catch (Exception e)
    {
    	//e.printStackTrace();
    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        return -1;
    }
    finally
    {
        if (tx.isActive())
        {
            tx.rollback();
        }
        pm.close();
    }
}
    public long eliminarClienteActivoPorReserva (long idReserva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlClienteActivo.eliminarClienteActivoPorReserva(pm, idReserva);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}	
    public List<ClienteActivo> darClienteActivo() {
        return sqlClienteActivo.darClienteActivo(pmf.getPersistenceManager());
    }
    
    public ClienteActivo darClienteActivoPorId(BigDecimal idCliente) {
        return sqlClienteActivo.darClienteActivoPorId(pmf.getPersistenceManager(), idCliente);
    }
    
    public List<ClienteActivo> darClienteActivoPorReserva(long idReserva) {
        return sqlClienteActivo.darClienteActivoPorReserva(pmf.getPersistenceManager(), idReserva);
    }
    
    
    
    
    
    
    
    
    
    public Cuenta adicionarCuenta(BigDecimal total) 
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            long idCuenta = nextval();
            BigDecimal idCuentaBD = new BigDecimal(idCuenta);
            long tuplasInsertadas = sqlCuenta.adicionarCuenta(pm, idCuentaBD, total);
            tx.commit();

            log.trace("Inserción de : " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");
        
            return new Cuenta(idCuentaBD, total);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }       
	}
    public long eliminarCuentaPorId (long idCuenta)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuenta.eliminarCuentaPorId(pm, idCuenta);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	} 
    
    public long eliminarCuentaPorTotal (int total)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuenta.eliminarCuentaPorTotal(pm, total);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	} 
    public Cuenta darCuenta() {
        return sqlCuenta.darCuenta(pmf.getPersistenceManager());
    }
    
    
    public  List<Cuenta> darCuentas ()
	{
    	return sqlCuenta.darCuentas (pmf.getPersistenceManager());
	}
    
    
    
    
    public List<Cuenta> darCuentaPorId(long idCuenta) {
        return sqlCuenta.darCuentaPorId(pmf.getPersistenceManager(), idCuenta);
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
 public CuentaCargada adicionarCuentaCargada(long idCuenta, long idServicio) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            long tuplasInsertadas = sqlCuentaCargada.adicionarCuentaCargada(pm, idCuenta, idServicio);
            tx.commit();

            log.trace("Inserción de : " + idCuenta + ": " + tuplasInsertadas + " tuplas insertadas");
        
            return new CuentaCargada(idCuenta, idServicio);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }       
	}
 
 
 public long eliminarCuentaCargada(long idCuenta, long idServicio) 
	{
	 
	 PersistenceManager pm = pmf.getPersistenceManager();
     Transaction tx=pm.currentTransaction();
     try
     {
         tx.begin();
         long resp = sqlCuentaCargada.eliminarCuentaCargada(pm, idCuenta, idServicio);           
         tx.commit();

         return resp;
     }
     catch (Exception e)
     {
//     	e.printStackTrace();
     	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
     	return -1;
     }
     finally
     {
         if (tx.isActive())
         {
             tx.rollback();
         }
         pm.close();
     }
	 
	 
	}
 
 public List<CuentaCargada> darCuentaCargada ( )
	{
		return sqlCuentaCargada.darCuentaCargada (pmf.getPersistenceManager());

	}
 
 
 
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Empleado adicionarEmpleado(String nombre, long celular, String correo) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            long idEmpleado = nextval();
            long tuplasInsertadas = sqlEmpleado.adicionarEmpleado(pm, idEmpleado, nombre, celular, correo);
            tx.commit();

            log.trace("Inserción de : " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
        
            return new Empleado(idEmpleado, nombre, celular, correo);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }       
	}
    
    public long eliminarEmpleadoPorId (long idEmpleado)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlEmpleado.eliminarEmpleadoPorId(pm, idEmpleado);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    public long eliminarEmpleadoPorNombre (String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlEmpleado.eliminarEmpleadoPorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    public long eliminarEmpleadoPorCelular (long celular)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlEmpleado.eliminarEmpleadoPorCelular(pm, celular);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
    public long eliminarEmpleadoPorCorreo (String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlEmpleado.eliminarEmpleadoPorCorreo(pm, correo);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    public List<Empleado> darEmpleado() {
        return sqlEmpleado.darEmpleado(pmf.getPersistenceManager());
    }
	
	public List<Empleado> darEmpleadoPorId(long idCliente) {
        return sqlEmpleado.darEmpleadoPorId(pmf.getPersistenceManager(), idCliente);
    }
	
	public List<Empleado> darEmpleadoPorNombre(String nombre) {
        return sqlEmpleado.darEmpleadoPorNombre(pmf.getPersistenceManager(), nombre);
    }
	
	public List<Empleado> darEmpleadoPorCorreo(String correo) {
        return sqlEmpleado.darEmpleadoPorCorreo(pmf.getPersistenceManager(), correo);
    }
	
	public EmpleadoActivo adicionarEmpleadoActivo(long idHotel, long idEmpleado) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            long tuplasInsertadas = sqlEmpleadoActivo.adicionarEmpleado(pm,idHotel, idEmpleado);
            tx.commit();

            log.trace("Inserción de : " + idEmpleado + ": " + tuplasInsertadas + " tuplas insertadas");
        
            return new EmpleadoActivo(idHotel, idEmpleado);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }    
	}
	
	public long eliminarEmpleadoActivoPorId (long idEmpleado)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlEmpleadoActivo.eliminarEmpleadoActivoPorId(pm, idEmpleado);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
        public long eliminarEmpleadoActivoPorReserva (long idReserva)
    	{
    		PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx=pm.currentTransaction();
            try
            {
                tx.begin();
                long resp = sqlClienteActivo.eliminarClienteActivoPorReserva(pm, idReserva);
                tx.commit();
                return resp;
            }
            catch (Exception e)
            {
            	//e.printStackTrace();
            	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            }
            finally
            {
                if (tx.isActive())
                {
                    tx.rollback();
                }
                pm.close();
            }
    	}	
        public List<EmpleadoActivo> darEmpleadoActivo() {
        	
            return sqlEmpleadoActivo.darEmpleadoActivo(pmf.getPersistenceManager());
        }
        
        public  EmpleadoActivo darEmpleadoActivoPorId ( long idEmpleado) 
    	{
            return sqlEmpleadoActivo.darEmpleadoActivoPorId(pmf.getPersistenceManager(), idEmpleado);
        }
        
        public List<EmpleadoActivo> darEmpleadoeActivoPorIdHotel(long idHotel) {
            return sqlEmpleadoActivo.darEmpleadoActivoPorIdHotel(pmf.getPersistenceManager(), idHotel);
        }
        
    
        public Habitacion adicionarHabitacion(String nombre,String tipoHabitacion,BigDecimal numeroHabitacion,BigDecimal idEmpleado) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long idHabitacion = nextval();
                BigDecimal idHabitacionBD = new BigDecimal(idHabitacion);
                long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, idHabitacionBD, nombre, tipoHabitacion, numeroHabitacion, idEmpleado);
                tx.commit();

                log.trace("Inserción de Habitacion " + numeroHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");
                return new Habitacion(idHabitacionBD, nombre, tipoHabitacion, numeroHabitacion, idEmpleado);

            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return null;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionPorId(long idHabitacion) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacion.eliminarHabitacionPorId(pm, idHabitacion);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }

        public long eliminarHabitacionPorNombre(String nombre) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacion.eliminarHabitacionPorNombre(pm, nombre);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionPorTipo(String tipoHabitacion) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacion.eliminarHabitacionPorTipo(pm, tipoHabitacion);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionPorNumero(long numero) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacion.eliminarHabitacionPorNumero(pm, numero);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionPorIdEmpleado(long idEmpleado) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacion.eliminarHabitacionPorIdEmpleado(pm, idEmpleado);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }

        public List<Habitacion> darHabitacion() {
            return sqlHabitacion.darHabitacion(pmf.getPersistenceManager());
        }
        
        public Habitacion darHabitacionPorId(long idHabitacion) {
            return sqlHabitacion.darHabitacionPorId(pmf.getPersistenceManager(), idHabitacion);
        }

        public List<Habitacion> darHabitacionPorNombre(String nombre) {
        return sqlHabitacion.darHabitacionPorNombre(pmf.getPersistenceManager(), nombre);
        }
        
        public List<Habitacion> darHabitacionPorTipo(String tipoHabitacion) {
            return sqlHabitacion.darHabitacionPorTipo(pmf.getPersistenceManager(), tipoHabitacion);
        }
        
        public List<Habitacion> darHabitacionPorNumero(String numero) {
            return sqlHabitacion.darHabitacionPorNumero(pmf.getPersistenceManager(), numero);
        }

        public List<Habitacion> darHabitacionesNoReservadas() {
            return sqlHabitacion.darHabitacionesNoReservadas(pmf.getPersistenceManager());
        }
        
        
        
        
        
        
        
        
        
        
        

        public HabitacionOfertada adicionarHabitacionOfertada(long idHotel, long idHabitacion) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long tuplasInsertadas = sqlHabitacionOfertada.adicionarHabitacionOfertada(pm, idHotel,idHabitacion);
                tx.commit();

                log.trace("Inserción de Habitacion " + idHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");
                return new HabitacionOfertada(idHotel, idHabitacion);

            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return null;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionOfertadaPorHotel(long idHotel) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacionOfertada.eliminarHabitacionOfertadaPorId(pm, idHotel);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionOfertadaPorId(long idHabitacion) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacionOfertada.eliminarHabitacionOfertadaPorId(pm, idHabitacion);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public List<HabitacionOfertada> darHabitacionOfertada() {
            return sqlHabitacionOfertada.darHabitacionOfertada(pmf.getPersistenceManager());
        }
        
        public List<HabitacionOfertada> darHabitacionOfertadaPorIdHotel(long idHotel) {
            return sqlHabitacionOfertada.darHabitacionOfertadaPorIdHotel(pmf.getPersistenceManager(), idHotel);
        }
        
        public List<HabitacionOfertada> darHabitacionOfertadaPorId(long idHabitacion) {
            return sqlHabitacionOfertada.darHabitacionOfertadaPorId(pmf.getPersistenceManager(), idHabitacion);
        }
        
        //// HAbitacion reservada ////
        
        public HabitacionReservada adicionarHabitacionReservada(BigDecimal idHabitacion, BigDecimal idReserva, BigDecimal idCuenta) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long tuplasInsertadas = sqlHabitacionReservada.adicionarHabitacionReservada(pm, idHabitacion, idReserva, idCuenta);
                tx.commit();

                log.trace("Inserción de Habitacion " + idHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");
                return new HabitacionReservada(idHabitacion, idReserva, idCuenta);

            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return null;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionReservadaPorId(BigDecimal idHabitacion) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacionReservada.eliminarHabitacionReservadaPorId(pm, idHabitacion);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public long eliminarHabitacionReservadaPorIdReserva(BigDecimal idReserva) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacionReservada.eliminarHabitacionReservadaPorId(pm, idReserva);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        
        public long eliminarHabitacionReservadaPorIdCuenta(long idCuenta) {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                long resp = sqlHabitacionReservada.eliminarHabitacionReservadaPorIdCuenta(pm, idCuenta);
                tx.commit();
                return resp;
            } catch (Exception e) {
                // e.printStackTrace();
                log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return -1;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
        
        public List<HabitacionReservada> darHabitacionReservada() {
            return sqlHabitacionReservada.darHabitacionReservada(pmf.getPersistenceManager());
        }
        
        public List<HabitacionReservada> darHabitacionReservadaPorIdCuenta(long idHabitacion) {
            return sqlHabitacionReservada.darHabitacionReservadaPorIdCuenta(pmf.getPersistenceManager(), idHabitacion);
        }
        
        public List<HabitacionReservada> darHabitacionReservadaPorId(long idReserva) {
            return sqlHabitacionReservada.darHabitacionReservadaPorId(pmf.getPersistenceManager(), idReserva);
        }

        public List<HabitacionReservada> darHabitacionReservadaPorIdReserva(long idReserva) {
            return sqlHabitacionReservada.darHabitacionReservadaPorIdReserva(pmf.getPersistenceManager(), idReserva);
        }
     



	//// HOTEL ////



	public Hotel adicionarHotel ( String nombre, String ubicacion, String paginaweb, long numero) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idHotel = nextval ();
            long tuplasInsertadas = sqlHotel.adicionarHotel(pm,idHotel, nombre,  ubicacion,  paginaweb,  numero );
            tx.commit();

            log.trace ("Inserción de Hotek: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Hotel (idHotel, nombre,  ubicacion,  paginaweb,  numero);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        
        
			
		
	}
	
	
	
	public long eliminarHotelPorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHotel.eliminarHotelPorNombre(pm, nombre);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	public long eliminaHotelPorId (long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHotel.eliminaHotelPorId (pm, idHotel);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<Hotel> darHoteles ()
	{
		return sqlHotel.darHoteles (pmf.getPersistenceManager());
	}
	
	
	public List<Hotel> darHotelesPorNombre (String nombre)
	{
		return sqlHotel.darHotelesPorNombre (pmf.getPersistenceManager(), nombre);
	}
 
	
	public Hotel darHotelPorId (long idHotel)
	{
		return sqlHotel.darHotelPorId (pmf.getPersistenceManager(), idHotel);
	}
	
	
	
	//// Metodo pago  ////
	
	
	
	public MetododePago adicionarMetodopago (String tipo, String nombre) 
	{
		

		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idMetodoPago = nextval ();
            long tuplasInsertadas = sqlMetodoPago.adicionarMetodopago(pm, idMetodoPago, tipo,nombre);
            tx.commit();

            log.trace ("Inserción de Metodo de pago: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new MetododePago (idMetodoPago, tipo,nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	
	}
	
	
	public long eliminarMetodopagoPorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlMetodoPago.eliminarMetodopagoPorNombre (pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public long eliminaMetodopagoPorId (long idMetodoPago) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlMetodoPago.eliminaMetodopagoPorId (pm, idMetodoPago);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public MetododePago darMetododePagoPorNombre (String nombre) 
	{
		return sqlMetodoPago.darMetododePagoPorNombre (pmf.getPersistenceManager(), nombre);
	}
	
	
	
	public List<MetododePago> darMetododePagos ()
	{
		return sqlMetodoPago.darMetododePagos (pmf.getPersistenceManager());
		
	}
	
	
	//// PLan de consumo  ////
	
	
	
	
	public PlanDeConsumo adicionarPlanDeConsumo(String nombre, int costo, Timestamp vigencia) 
	{
		
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idPlanConsumo = nextval ();
            long tuplasInsertadas = sqlPlanDeConsumo.adicionarPlanDeConsumo(pmf.getPersistenceManager(), idPlanConsumo, nombre, costo, vigencia);
            tx.commit();

            log.trace ("Inserción de PlanDeConsumo: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new PlanDeConsumo (idPlanConsumo, nombre, costo, vigencia);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	public long eliminarPlanDeConsumoPorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanDeConsumo.eliminarPlanDeConsumoPorNombre (pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public long eliminaPlanDeConsumoPorId (long idPlanConsumo) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanDeConsumo.eliminaPlanDeConsumoPorId (pm, idPlanConsumo);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public List<PlanDeConsumo> darPlanDeConsumosPorNombre (String nombre) 
	{
		return sqlPlanDeConsumo.darPlanDeConsumosPorNombre (pmf.getPersistenceManager(), nombre);
	}
	
	
	
	public PlanDeConsumo darPlanDeConsumoPorId (long idPlanConsumo) 
	{
		return  sqlPlanDeConsumo.darPlanDeConsumoPorId (pmf.getPersistenceManager(), idPlanConsumo);
	}
	
	
	public List<PlanDeConsumo> darPlanDeConsumos ()
	{
		return sqlPlanDeConsumo.darPlanDeConsumos (pmf.getPersistenceManager());

	}
	
	//// PLan de ofrecido  ////
	
	
	
	public PlanOfrecido adicionarPlanOfrecido(long idPlanConsumo, long idHotel) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlPlanOfrecido.adicionarPlanOfrecido (pm, idPlanConsumo, idHotel);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idPlanConsumo + ", " + idHotel + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new PlanOfrecido (idPlanConsumo, idHotel);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	public long eliminarPlanOfrecido(long idPlanConsumo, long idHotel) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanOfrecido.eliminarPlanOfrecido(pm, idPlanConsumo, idHotel);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public List<PlanOfrecido> darPlanOfrecidos ()
	{
		return sqlPlanOfrecido.darPlanOfrecidos (pmf.getPersistenceManager());
	}

	
	
	
	
	//// adicionar reserva    ////
	
	
	
	public Reserva adicionarReserva(Timestamp fechaEntrada, Timestamp fechaSalida, BigDecimal numeroPersonas, BigDecimal idCliente,BigDecimal plan_de_pago,String estado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idReserva = nextval ();
            BigDecimal idReservaBD = new BigDecimal(0);
            long tuplasInsertadas = sqlReserva.adicionarReserva(pm,idReserva,fechaEntrada, fechaSalida, numeroPersonas, idCliente, plan_de_pago, estado);
            tx.commit();

            log.trace ("Inserción de Reserva: " + idReserva + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Reserva (idReservaBD,fechaEntrada, fechaSalida, numeroPersonas, idCliente,plan_de_pago, estado);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	
	
	public long eliminarReservasPorEstado ( String estado)
	{	
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservasPorEstado(pm, estado);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }	
		
	}
		
	
	
	public long eliminarReservasPorplan_de_pago ( int plan_de_pago)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservasPorplan_de_pago(pm, plan_de_pago);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }	
		
		
		
	}
	
	
	
	
	
	public long eliminarReservasPorIdcliente ( long idCliente) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservasPorIdcliente(pm, idCliente);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	public long eliminaReservaPorId ( long idReserva) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminaReservaPorId(pm, idReserva);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public List<Reserva> darReservasPorIdcliente (long idCliente)
	{
		return sqlReserva.darReservasPorIdcliente (pmf.getPersistenceManager(), idCliente);

	}
	
	
	public List<Reserva> darReservasPorestado(String estado) 
	{
		
		return sqlReserva.darReservasPorestado (pmf.getPersistenceManager(), estado);

	}
	
	public List<Reserva> darReservasPorIdPlanPago (BigDecimal idPlanPago)
	{
		return sqlReserva.darReservasPorIdPlanPago(pmf.getPersistenceManager(), idPlanPago);

	}
	
	
	public List<Reserva> darReservas ()
	{
		return sqlReserva.darReservas (pmf.getPersistenceManager());
		
	}
	
	
	public long aumentarNumeroPersonasReserva (long idReserva)
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.aumentarNumeroPersonasReserva(pm, idReserva);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}

    public long liberarReserva (BigDecimal idReserva)
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.liberarReserva(pm, idReserva);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	
	//// Servicio  OFRECIDO    ////
	
	
	
	public ServicioOfrecido adicionarServicioOfrecido(long idServicio, long idHotel) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlServicioOfrecido.adicionarServicioOfrecido (pm, idServicio, idHotel);
            tx.commit();

            log.trace ("Inserción de ServicioOfrecido: [" + idServicio + ", " + idHotel + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new ServicioOfrecido (idServicio, idHotel);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public long eliminarServicioOfrecido(long idServicio, long idHotel) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioOfrecido.eliminarServicioOfrecido(pm, idServicio, idHotel);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
		
	}
	
	
	
	public List<ServicioOfrecido> darServicioOfrecido ()
	{
		return sqlServicioOfrecido.darServicioOfrecido (pmf.getPersistenceManager());
	}

	
	
	//// Servicio  SOLICITADO    ////
	
	
	public ServicioSolicitado adicionarServicio_Solicitado (BigDecimal idServicio, BigDecimal numpersonas, BigDecimal Costo,Timestamp fecha_solicitud) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlServicioSolicitado.adicionarServicio_Solicitado(pmf.getPersistenceManager(), idServicio, numpersonas, Costo,fecha_solicitud);
            tx.commit();

            log.trace ("Inserción de idServicio: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ServicioSolicitado (idServicio, numpersonas, Costo,fecha_solicitud);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	
	
	public long eliminarServicio_SolicitadoPorId(long idServicio)
	{
		

		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioSolicitado.eliminarServicio_SolicitadoPorId (pm, idServicio);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public List<ServicioSolicitado>   darServicio_Solicitadoporfecha_solicitud ( Timestamp fecha_solicitud) 
	{
		return sqlServicioSolicitado.darServicio_Solicitadoporfecha_solicitud (pmf.getPersistenceManager(),fecha_solicitud);
		
	}
	
	
	public ServicioSolicitado  darServicio_SolicitadopoID (long idServicio) 
	{
		return sqlServicioSolicitado.darServicio_SolicitadopoID (pmf.getPersistenceManager(), idServicio);

	}
	
	
	public  List<ServicioSolicitado> darServicio_Solicitado ()
	{
		
		return sqlServicioSolicitado.darServicio_Solicitado (pmf.getPersistenceManager());

		
		
	}
	
	
	public long aumentarnumeroPersonasServicio_SolicitadoID ( long idServicio)
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioSolicitado.aumentarnumeroPersonasServicio_SolicitadoID(pm, idServicio);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	//// Servicio      ////
	
	
	public Servicio adicionarServicio(String nombre, String descripcion, BigDecimal area, BigDecimal costo) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idServicio = nextval();
            BigDecimal idServicioBD = new BigDecimal(idServicio);
            long tuplasInsertadas = sqlServicio.adicionarServicio(pm, idServicioBD, nombre, descripcion, area, costo);
            tx.commit();

            log.trace ("Inserción de Servicio: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Servicio (idServicioBD, nombre, descripcion, area,costo);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public long eliminarServicioPorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicio.eliminarServicioPorNombre(pm, nombre);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	public long eliminaServicioPorId (BigDecimal idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicio.eliminaServicioPorId (pm, idServicio);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public List<Servicio> darServicios ()
	{
		return sqlServicio.darServicios (pmf.getPersistenceManager());
	}
	
	
	public List<Servicio> darServicioPorNombre (String nombre)
	{
		return sqlServicio.darServicioPorNombre (pmf.getPersistenceManager(), nombre);
	}
	
	
	
	//// Tipo habitacion    ////
	
	
	public TipoHabitacion adicionarTipo_Habitacion (String tipoHabitacion ,BigDecimal capacidad, BigDecimal area) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
          
            long tuplasInsertadas = sqlTipoHabitacion.adicionarTipo_Habitacion(pm, tipoHabitacion, capacidad, area);
            tx.commit();

            log.trace ("Inserción de Tipo habitacion: " + tipoHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");

            return new TipoHabitacion (tipoHabitacion, capacidad, area);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	
	
	public List<TipoHabitacion> darTipo_Habitacion ()
	{
		
		return sqlTipoHabitacion.darTipo_Habitacion (pmf.getPersistenceManager());

	}

	
	public long eliminarTipo_Habitacion( String tipoHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlTipoHabitacion.eliminarTipo_Habitacion (pm, tipoHabitacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	public TipoHabitacion darTipo_HabitacionPortipoHabitacion (String tipoHabitacion)
	{
		return sqlTipoHabitacion.darTipo_HabitacionPortipoHabitacion (pmf.getPersistenceManager(), tipoHabitacion);
	}
	
	
	
	//// Tipo reserva    ////
	
	
	
	public TipoReserva adicionarTipoReserva(long idReserva, long idPlanConsumo) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTipoReserva.adicionarTipoReserva (pm, idReserva, idPlanConsumo);
            tx.commit();

            log.trace ("Inserción de Tipo reserva: [" + idReserva + ", " + idPlanConsumo + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new TipoReserva (idReserva, idPlanConsumo);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public long eliminarTipoReserva(long idReserva, long idPlanConsumo) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlTipoReserva.eliminarTipoReserva(pm, idReserva, idPlanConsumo);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public List<TipoReserva> darTipoReserva ()
	{
		return sqlTipoReserva.darTipoReserva (pmf.getPersistenceManager());
	}
	

//ROL USUARIO

public RolUsuario adicionarRolUsuario(BigDecimal numero_documento, String rol) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlRolUsuario.adicionarRolUsuario (pm, numero_documento, rol);
            tx.commit();

            log.trace ("Inserción de rol de usuario: [" + numero_documento + ", " + rol + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new RolUsuario (numero_documento, rol);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public long eliminarRolUsuario(long numero_documento) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlRolUsuario.eliminarRolUsuario(pm, numero_documento);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}

    public RolUsuario darRolUsuarioPorNumeroDocumento(long numero_documento){
        return sqlRolUsuario.darRolUsuarioPorNumeroDocumento(pmf.getPersistenceManager(), numero_documento);
    }
	
	
	public List<RolUsuario> darRolesUsuario ()
	{
		return sqlRolUsuario.darRolesUsuario (pmf.getPersistenceManager());
	}

//Organizador eventos

public OrganizadorEventos adicionarOrganizadorEventos(BigDecimal idUsuario,BigDecimal numero_documento, String nombre, String apellido, String correo, BigDecimal planDePagoAcordado) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            //long idUsuario = nextval();
            //long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, idUsuario, numero_documento, nombre, apellido, correo);
            //long tuplasInsertadas1 = sqlRolUsuario.adicionarRolUsuario(pm, numero_documento, "Organizador_Eventos");
            long tuplasInsertadas2 = sqlOrganizadorEventos.adicionarOrganizadorEventos (pm, numero_documento, planDePagoAcordado);
            tx.commit();

            //log.trace("Inserción de : " + nombre + ": " + tuplasInsertadas + " tuplas insertadas como organizador de eventos");
            //log.trace ("Inserción de rol de usuario: [" + numero_documento + ", Organizador_Eventos]. " + tuplasInsertadas1 + " tuplas insertadas");
            log.trace ("Inserción de organizador de eventos: [" + numero_documento + ", " + planDePagoAcordado + "]. " + tuplasInsertadas2 + " tuplas insertadas");

            return new OrganizadorEventos (idUsuario,numero_documento, nombre, apellido, correo, planDePagoAcordado);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public long eliminarOrganizadorEventos(long numero_documento, long planDePagoAcordado) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlOrganizadorEventos.eliminarOrganizadorEventos(pm, numero_documento, planDePagoAcordado);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
		
	}
	
	
	public List<OrganizadorEventos> darOrganizadorEventos ()
	{
		return sqlOrganizadorEventos.darOrganizadorEventos (pmf.getPersistenceManager());
	}

//Plan de pago acordado

    public PlanDePagoAcordado adicionarPlanDePagoAcordado(String tipoHabitaciones, int numeroHabitaciones, int numeroPersonas, Timestamp fechaInicio, Timestamp fechaSalida, String estado) 
        {
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx=pm.currentTransaction();
            try
            {
                tx.begin();
                long idPlanDePagoAcordado = nextval ();
                long tuplasInsertadas = sqlPlanDePagoAcordado.adicionarPlanDePagoAcordado(pm, idPlanDePagoAcordado, tipoHabitaciones, numeroHabitaciones, numeroPersonas, fechaInicio, fechaSalida, estado);
                tx.commit();

                log.trace ("Inserción de PlanDePagoAcordado: " + idPlanDePagoAcordado + ": " + tuplasInsertadas + " tuplas insertadas");

                return new PlanDePagoAcordado (idPlanDePagoAcordado, tipoHabitaciones, numeroHabitaciones, numeroPersonas, fechaInicio, fechaSalida, estado);
            }
            catch (Exception e)
            {
    //        	e.printStackTrace();
                log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
                return null;
            }
            finally
            {
                if (tx.isActive())
                {
                    tx.rollback();
                }
                pm.close();
            }
            
        }
        
        
        
        
    public long eliminarPlanDePagoAcordadosPorEstado ( String estado)
    {	
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanDePagoAcordado.eliminarPlanDePagoAcordadosPorEstado(pm, estado);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }	
        
    }
        
    
    
    public long eliminarPlanDePagoAcordadosPorTipoHabitacion ( String tipoHabitacion)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanDePagoAcordado.eliminarPlanDePagoAcordadosPorTipoHabitacion(pm, tipoHabitacion);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }	
        
        
        
    }
    
    public long eliminaPlanDePagoAcordadoPorId ( long idPlanDePagoAcordado) 
    {
        
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPlanDePagoAcordado.eliminaPlanDePagoAcordadoPorId(pm, idPlanDePagoAcordado);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    public List<PlanDePagoAcordado> darPlanDePagoAcordadosPorestado(String estado) 
    {
        
        return sqlPlanDePagoAcordado.darPlanDePagoAcordadosPorestado (pmf.getPersistenceManager(), estado);

    }

    public List<PlanDePagoAcordado> darPlanDePagoAcordadosPorTipoHabitacion(String tipoHabitacion) 
    {
        
        return sqlPlanDePagoAcordado.darPlanDePagoAcordadoPorTipoHabitacion(pmf.getPersistenceManager(), tipoHabitacion);

    }
    
    public List<PlanDePagoAcordado> darPlanDePagoAcordados ()
    {
        return sqlPlanDePagoAcordado.darPlanDePagoAcordados (pmf.getPersistenceManager());
        
    }




    /**
     * 
     * Limipiar tablas
     * 
     */
	
	public long [] limpiarHotelAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarHotelAndes (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	

 }


 

 
	
	
	
	
	
	
	
	
	
		

