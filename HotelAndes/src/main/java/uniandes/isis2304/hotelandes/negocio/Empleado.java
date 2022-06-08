package uniandes.isis2304.hotelandes.negocio;

public class Empleado implements VOEmpleado

{
	
	private long idEmpleado;

	private String nombre;

	private long celular;

	private String correo;


	public Empleado() 
    {
    	this.idEmpleado = 0;
		this.nombre = "";
    	this.celular = 0;
		this.correo = "";
	
	}
	
	
	public Empleado(long idEmpleado, String nombre, long celular, String correo) 
    {
    	this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.celular = celular;
		this.correo = correo;
	}


	public long getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getCelular() {
		return celular;
	}


	public void setCelular(long celular) {
		this.celular = celular;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", celular=" + celular + ", correo="
				+ correo + "]";
	}
	
	
	
	
	
}
