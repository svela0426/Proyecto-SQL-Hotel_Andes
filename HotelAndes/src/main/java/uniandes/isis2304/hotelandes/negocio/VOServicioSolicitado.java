package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface VOServicioSolicitado {
	
	
	public BigDecimal getIdServicio();


	public BigDecimal getNumpersonas();


	public BigDecimal getCosto();
	

	public Timestamp getFecha_solicitud();


	@Override
	public String toString();
	
	
	
	

	

}
