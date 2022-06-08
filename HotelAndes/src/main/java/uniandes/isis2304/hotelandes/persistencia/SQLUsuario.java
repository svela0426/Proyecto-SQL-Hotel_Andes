package uniandes.isis2304.hotelandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Usuario;

public class SQLUsuario {

	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;

	public SQLUsuario (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}
	
	public long adicionarUsuario(PersistenceManager pm, BigDecimal idUsuario, BigDecimal numero,String nombre,String apellido,String correo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ph.darTablaUsuario () + "(idUsuario, Numero, Nombre, Apellido, Correo) values (?, ?, ?, ?, ?)");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();
	}
	
	public Usuario darUsuarioPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario () + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}
	
	public long eliminarUsuarioPorId (PersistenceManager pm, long idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaUsuario () + " WHERE id = ?");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();            
	}
	
	public long eliminarUsuarioPorNumero (PersistenceManager pm, long numero)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaUsuario () + " WHERE numero = ?");
        q.setParameters(numero);
        return (long) q.executeUnique();            
	}
	
	public long eliminarUsuarioPorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaUsuario () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	public long eliminarUsuarioPorApellido (PersistenceManager pm, String apellido)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaUsuario () + " WHERE apellido = ?");
        q.setParameters(apellido);
        return (long) q.executeUnique();            
	}
	
	public long eliminarUsuarioPorCorreo (PersistenceManager pm, String correo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + ph.darTablaUsuario () + " WHERE correo = ?");
        q.setParameters(correo);
        return (long) q.executeUnique();            
	}
	
	

	
	public List<Usuario> darUsuarios(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario ());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
	
	public List<Usuario> darUsuarioPorNumero (PersistenceManager pm, long numero) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario () + " WHERE numero = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(numero);
		return (List<Usuario>) q.executeList();
	}
	
	public List<Usuario> darUsuarioPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario () + " WHERE nombre = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(nombre);
		return (List<Usuario>) q.executeList();
	}
	
	public List<Usuario> darUsuarioPorApellido (PersistenceManager pm, String apellidoCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario () + " WHERE apellido = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(apellidoCliente);
		return (List<Usuario>) q.executeList();
	}
	
	public List<Usuario> darUsuarioPorCorreo (PersistenceManager pm, String correoCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ph.darTablaUsuario () + " WHERE correo = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(correoCliente);
		return (List<Usuario>) q.executeList();
	}
	
	
	
	

}
