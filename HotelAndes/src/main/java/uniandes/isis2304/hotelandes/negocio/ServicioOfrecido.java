package uniandes.isis2304.hotelandes.negocio;

public class ServicioOfrecido implements VOServicioOfrecido
{
	
	private long idServicio;
	
	private long idHotel;
	
	
	public ServicioOfrecido() 
	{
		this.idServicio = 0;
		this.idHotel = 0;
	}
	
	
	public ServicioOfrecido(long idServicio, long idHotel) 
	{
		this.idServicio = idServicio;
		this.idHotel = idHotel;
	}
	
	
	
	
	


	public long getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}


	public long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}


	@Override
	public String toString() {
		return "ServicioOfrecido [idServicio=" + idServicio + ", idHotel=" + idHotel + "]";
	}
	
	



}
