package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Habitacion implements VOHabitacion
{

	private BigDecimal idHabitacion;
	
	private String nombre;
	
	private String tipoHabitacion;
	
	private BigDecimal numeroHabitacion;
	
	private BigDecimal idUsuario;
	
	
	public Habitacion() 
    {
    	this.idHabitacion = new BigDecimal(0);   	
		this.nombre = "";
		this.tipoHabitacion = "";
    	this.numeroHabitacion = new BigDecimal(0);
    	this.idUsuario = new BigDecimal(0);   	   	

	}
	
	
	public Habitacion(BigDecimal idHabitacion,String nombre,String tipoHabitacion,BigDecimal numeroHabitacion,BigDecimal idUsuario) 
    {
		this.idHabitacion = idHabitacion;   	
		this.nombre = nombre;
		this.tipoHabitacion = tipoHabitacion;
    	this.numeroHabitacion = numeroHabitacion;  
    	this.idUsuario = idUsuario;  
	}


	public BigDecimal getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(BigDecimal idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}


	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}


	public BigDecimal getNumeroHabitacion() {
		return numeroHabitacion;
	}


	public void setNumeroHabitacion(BigDecimal numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}


	public BigDecimal getIdEmpleado() {
		return idUsuario;
	}


	public void setIdEmpleado(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}


	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + ", nombre=" + nombre + ", tipoHabitacion=" + tipoHabitacion
				+ ", numeroHabitacion=" + numeroHabitacion + ", idUsuario=" + idUsuario + "]";
	}

	
	
	
	

	
	

	
	


	
	
}
