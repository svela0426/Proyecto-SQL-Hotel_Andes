package uniandes.isis2304.hotelandes.negocio;

public class MetododePago implements VOMetododePago
{
	
	private long idMetodoPago;

	
	private String tipo;

	
	private String nombre;
	
	
	
	public MetododePago() 
    {
    	this.idMetodoPago = 0;   
    	this.tipo = "";
    	this.nombre = "";
	}
	
	
	public MetododePago(long idMetodoPago,String tipo,String nombre) 
    {
		this.idMetodoPago = idMetodoPago;   
    	this.tipo = tipo;
    	this.nombre = nombre;
	}


	public long getIdMetodoPago() {
		return idMetodoPago;
	}


	public void setIdMetodoPago(long idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "MetododePago [idMetodoPago=" + idMetodoPago + ", tipo=" + tipo + ", nombre=" + nombre + "]";
	}
	
	
	


}
