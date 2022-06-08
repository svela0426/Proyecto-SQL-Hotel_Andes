package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public interface VOUsuario
{
	
	public BigDecimal getIdUsuario();


	public BigDecimal getNumero();


	public String getNombre();



	public String getApellido();


	public String getCorreo();


	@Override
	public String toString();

}
