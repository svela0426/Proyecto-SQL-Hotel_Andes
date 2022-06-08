package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class HabitacionReservada implements VOHabitacionReservada

{
	
	private BigDecimal idHabitacion;
	
	private BigDecimal idReserva;
	
	private BigDecimal idCuenta;
	
	
	public HabitacionReservada() 
    {
    	this.idHabitacion = new BigDecimal(0);   
    	this.idReserva = new BigDecimal(0); 
    	this.idCuenta = new BigDecimal(0);  


	}
	
	
	public HabitacionReservada(BigDecimal idHabitacion,BigDecimal idReserva,BigDecimal idCuenta) 
    {
		this.idHabitacion = idHabitacion;   
    	this.idReserva = idReserva;
    	this.idCuenta = idCuenta;   
	}


	public BigDecimal getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(BigDecimal idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	public BigDecimal getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(BigDecimal idReserva) {
		this.idReserva = idReserva;
	}


	public BigDecimal getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(BigDecimal idCuenta) {
		this.idCuenta = idCuenta;
	}


	@Override
	public String toString() {
		return "HabitacionReservada [idHabitacion=" + idHabitacion + ", idReserva=" + idReserva + ", idCuenta="
				+ idCuenta + "]";
	}
	
	
	
	
	
	


}



