package uniandes.isis2304.hotelandes.negocio;


public class TipoReserva implements VOTipoReserva
{
	
	private long idReserva;
	
	private long idPlanConsumo;
	
	
	
	public TipoReserva() 
	{
		this.idReserva = 0;

		this.idPlanConsumo = 0;
		
	}
	
	
	public TipoReserva(long idPlanConsumo,long idReserva ) 
	{
		
		this.idReserva = idReserva;

		this.idPlanConsumo =idPlanConsumo ;

	}


	public long getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}


	public long getIdPlanConsumo() {
		return idPlanConsumo;
	}


	public void setIdPlanConsumo(long idPlanConsumo) {
		this.idPlanConsumo = idPlanConsumo;
	}


	@Override
	public String toString() {
		return "TipoReserva [idReserva=" + idReserva + ", idPlanConsumo=" + idPlanConsumo + "]";
	}
	
	
		


	
	


}
