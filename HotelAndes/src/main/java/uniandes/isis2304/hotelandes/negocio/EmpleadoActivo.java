package uniandes.isis2304.hotelandes.negocio;

public class EmpleadoActivo implements VOEmpleadoActivo
{
	
	private long idHotel;
	private long idEmpleado;
	
	
	public EmpleadoActivo() 
    {
    	this.idHotel = 0;
		this.idEmpleado = 0;

	}
	
	public EmpleadoActivo(long idHotel, long idEmpleado) 
    {
    	this.idHotel = idHotel;
    	this.idEmpleado = idEmpleado;

		
    }

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "EmpleadoActivo [idHotel=" + idHotel + ", idEmpleado=" + idEmpleado + "]";
	}



}
