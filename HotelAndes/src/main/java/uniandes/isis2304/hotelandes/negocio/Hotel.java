package uniandes.isis2304.hotelandes.negocio;

public class Hotel implements VOHotel

{
	
	private long idHotel;

	private String nombre;

	private String ubicacion;

	private String paginaweb;

	private long numero;
	
	
	
	public Hotel() 
    {
    	this.idHotel = 0;   
    	this.nombre = "";
    	this.ubicacion = "";   
    	this.paginaweb = ""; 
    	this.numero = 0;   

	}
	
	public Hotel(long idHotel,String nombre,String ubicacion,String paginaweb,long numero) 
    {
		this.idHotel = idHotel;   
    	this.nombre = nombre;
    	this.ubicacion = ubicacion;   
    	this.paginaweb = paginaweb; 
    	this.numero = numero;   
   
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getPaginaweb() {
		return paginaweb;
	}

	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", paginaweb="
				+ paginaweb + ", numero=" + numero + "]";
	}

	
	

	
	
	
	
	
}
