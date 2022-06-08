package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Usuario implements VOUsuario
{
	private BigDecimal idUsuario;
	
	private BigDecimal numero;
	
	private String nombre;

	private String apellido;
	
	private String correo;
	

	
	
	
	
	public Usuario() 
    {
    	this.idUsuario = new BigDecimal(0);
    	this.numero = new BigDecimal(0);  	
		this.nombre = "";
		this.apellido = "";
		this.correo = "";
	}
	
	public Usuario(BigDecimal idUsuario,BigDecimal numero,String nombre,String apellido,String correo) 
    {
		this.idUsuario = idUsuario;
    	this.numero =numero ;    	
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
    	
	}

	public BigDecimal getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getNumero() {
		return numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", numero=" + numero + ", nombre=" + nombre + ", apellido="
				+ apellido + ", correo=" + correo + "]";
	}


	
	
	
	
}

	