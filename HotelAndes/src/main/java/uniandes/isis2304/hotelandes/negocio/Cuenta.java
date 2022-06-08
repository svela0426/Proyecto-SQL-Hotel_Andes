package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Cuenta  implements VOCuenta


{
	
	private BigDecimal idCuenta;	
	
	private BigDecimal total;	
	
	public Cuenta() 
	{
		this.idCuenta = new BigDecimal(0);
		this.total = new BigDecimal(0);

	}
	
	public Cuenta(BigDecimal idCuenta, BigDecimal total) 
	{
		this.idCuenta = idCuenta;
		this.total = total;

	}

	public BigDecimal getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(BigDecimal idCuenta) {
		this.idCuenta = idCuenta;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", total=" + total + "]";
	}
	
	
	
	
		

	

}
