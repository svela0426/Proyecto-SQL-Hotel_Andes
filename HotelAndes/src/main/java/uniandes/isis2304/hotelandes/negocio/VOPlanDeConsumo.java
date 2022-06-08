package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public interface VOPlanDeConsumo {
	
	
	public long getIdPlanConsumo();



	public String getNombre();


	public int getCosto();



	public Timestamp getVigencia();


	@Override
	public String toString();
	

}
