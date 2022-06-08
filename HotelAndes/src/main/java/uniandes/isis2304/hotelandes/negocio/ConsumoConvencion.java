 package uniandes.isis2304.hotelandes.negocio;

public class ConsumoConvencion implements VOConsumoConvencion

{
	
	private long idPlandePago;
	
	private String servicioSolicitado;
	
	private int capacidad;
	
	private int precio;



	public ConsumoConvencion() 
	{
    	this.idPlandePago = 0;
    	this.servicioSolicitado = "";
    	this.capacidad = 0;
    	this.precio = 0;

	}
	
	
	
	public ConsumoConvencion( long idPlandePago,String servicioSolicitado, int capacidad,int precio) 
	{
		this.idPlandePago = idPlandePago;
    	this.servicioSolicitado = servicioSolicitado;
    	this.capacidad = capacidad;
    	this.precio = precio;

	}



	public long getIdPlandePago() {
		return idPlandePago;
	}



	public void setIdPlandePago(long idPlandePago) {
		this.idPlandePago = idPlandePago;
	}



	public String getServicioSolicitado() {
		return servicioSolicitado;
	}



	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}



	public int getCapacidad() {
		return capacidad;
	}



	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}



	public int getPrecio() {
		return precio;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "ConsumoConvencion [idPlandePago=" + idPlandePago + ", servicioSolicitado=" + servicioSolicitado
				+ ", capacidad=" + capacidad + ", precio=" + precio + "]";
	}
	
	


	
	
	

}
