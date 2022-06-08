package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class TipoHabitacion implements VOTipoHabitacion
{
	
	private String tipoHabitacion;

	
	private BigDecimal capacidad;

	
	private BigDecimal area;

	
	
	public TipoHabitacion() 
    {
    	  	
		this.tipoHabitacion = "";
		this.capacidad = new BigDecimal(0);
    	this.area = new BigDecimal(0); 	

	}
	
	
	public TipoHabitacion(String tipoHabitacion,BigDecimal capacidad,BigDecimal area) 
    {
		
		this.tipoHabitacion = tipoHabitacion;
		this.capacidad = capacidad;
    	this.area = area;  
	 
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}


	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}


	public BigDecimal getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(BigDecimal capacidad) {
		this.capacidad = capacidad;
	}


	public BigDecimal getArea() {
		return area;
	}


	public void setArea(BigDecimal area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "TipoHabitacion [tipoHabitacion=" + tipoHabitacion + ", capacidad=" + capacidad + ", area=" + area + "]";
	}
	
	
	
	
	
	
	
	
	

}
