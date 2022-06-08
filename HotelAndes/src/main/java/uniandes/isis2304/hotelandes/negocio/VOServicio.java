package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public interface VOServicio {
	
	
	public BigDecimal getIdServicio();

	public String getNombre();

	public String getDescripcion();

	public BigDecimal getArea();

	public BigDecimal getCosto();

	@Override
	public String toString();
	
	



}
