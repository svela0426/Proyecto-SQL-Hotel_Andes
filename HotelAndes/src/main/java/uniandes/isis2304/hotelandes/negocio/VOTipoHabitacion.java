package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public interface VOTipoHabitacion {

	
	
	public String getTipoHabitacion();


	public BigDecimal getCapacidad();


	public BigDecimal getArea();

	@Override
	public String toString();
	
	
	
	
	
}
