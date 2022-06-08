package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface VOReserva {
	
	
	public BigDecimal getIdReserva();

	public Timestamp getFechaEntrada();

	public Timestamp getFechaSalida();

	public BigDecimal getNumeroPersonas();
	
	public BigDecimal getIdCliente();

	public BigDecimal getPlan_de_pago();
	
	
	public String getEstado();

	
	
	@Override
	public String toString();
	
	
	

}
