package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public interface VOCliente {
	
	
	public BigDecimal getid();

	public BigDecimal getmetodoPago();

	public BigDecimal gethotelPerteneciente();


	public BigDecimal getidPlanPago();
	
	
	public String toString() ;

}
