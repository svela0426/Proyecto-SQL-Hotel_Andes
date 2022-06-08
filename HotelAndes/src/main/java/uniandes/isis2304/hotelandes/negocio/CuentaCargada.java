package uniandes.isis2304.hotelandes.negocio;

public class CuentaCargada  implements VOCuentaCargada

{
	
	private long idCuenta;	
	
	private long idServicio;
	
	
	
	public CuentaCargada() 
	{
		this.idCuenta = 0;
		this.idServicio = 0;

	}
	
	public CuentaCargada(long idCuenta, long idServicio) 
	{
		this.idCuenta = idCuenta;
		this.idServicio = idServicio;

	}

	public long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "CuentaCargada [idCuenta=" + idCuenta + ", idServicio=" + idServicio + "]";
	}

	
	


}
