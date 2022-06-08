package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Cliente implements VOCliente {
	
	 
	private BigDecimal id;

	private BigDecimal metodoPago;
	
	private BigDecimal hotelPerteneciente;
	
	private BigDecimal idPlanPago;
	

	
	
	public Cliente() 
	{
    	this.metodoPago = new BigDecimal(0);
    	this.hotelPerteneciente = new BigDecimal(0);
    	this.idPlanPago = new BigDecimal(0);
    	this.id = new BigDecimal(0);

    	
	
	}
	
	/*
	public Cliente(BigDecimal id,BigDecimal metodoPago,BigDecimal hotelPerteneciente,BigDecimal idPlanPago) 
	{
		this.metodoPago = metodoPago;
    	this.hotelPerteneciente = hotelPerteneciente;
    	this.idPlanPago = idPlanPago;
    	this.id = id;	
	}
	*/
	public Cliente(BigDecimal id,BigDecimal metodoPago,BigDecimal hotelPerteneciente,BigDecimal idPlanPago) 
	{
		this.metodoPago = metodoPago;
    	this.hotelPerteneciente = hotelPerteneciente;
    	this.idPlanPago = idPlanPago;
    	this.id = id;	
	}

	


	public BigDecimal getid() {
		return id;
	}


	public void setid(BigDecimal id) {
		this.id = id;
	}


	public BigDecimal getmetodoPago() {
		return metodoPago;
	}


	public void setmetodoPago(BigDecimal metodoPago) {
		this.metodoPago = metodoPago;
	}


	public BigDecimal gethotelPerteneciente() {
		return hotelPerteneciente;
	}


	public void sethotelPerteneciente(BigDecimal hotelPerteneciente) {
		this.hotelPerteneciente = hotelPerteneciente;
	}


	public BigDecimal getidPlanPago() {
		return idPlanPago;
	}


	public void setidPlanPago(BigDecimal idPlanPago) {
		this.idPlanPago = idPlanPago;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", metodoPago=" + metodoPago + ", hotelPerteneciente=" + hotelPerteneciente
				+ ", idPlanPago=" + idPlanPago + "]";
	}
	
	
	
	


	
	
	
	
	
	
	
	
	

}
