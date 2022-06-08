package uniandes.isis2304.hotelandes.negocio;

public class HabitacionOfertada implements VOHabitacionOfertada
{
	
	
	private long idHotel;
	
	private long idHabitacion;
	
	
	public HabitacionOfertada() 
    {
    	this.idHotel = 0;   
    	this.idHabitacion = 0;   

	}
	
	
	public HabitacionOfertada(long idHabitacion,long idHotel) 
    {
		this.idHabitacion = idHabitacion; 
		this.idHotel = idHotel;   	

	
	}


	public long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}


	public long getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	@Override
	public String toString() {
		return "HabitacionOfertada [idHotel=" + idHotel + ", idHabitacion=" + idHabitacion + "]";
	}




}
