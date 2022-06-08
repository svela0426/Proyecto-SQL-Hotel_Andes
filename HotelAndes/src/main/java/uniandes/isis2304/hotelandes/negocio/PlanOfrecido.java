package uniandes.isis2304.hotelandes.negocio;


public class PlanOfrecido implements VOPlanOfrecido
{
	
	
	private long idPlanConsumo;

	private long idHotel;
	
	
	
	public PlanOfrecido() 
	{
		this.idPlanConsumo = 0;
		this.idHotel = 0;
	}
	
	public PlanOfrecido(long idPlanConsumo, long idHotel) 
	{
		this.idPlanConsumo = idPlanConsumo;
		this.idHotel = idHotel;
	}

	public long getIdPlanConsumo() {
		return idPlanConsumo;
	}

	public void setIdPlanConsumo(long idPlanConsumo) {
		this.idPlanConsumo = idPlanConsumo;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	@Override
	public String toString() {
		return "PlanOfrecido [idPlanConsumo=" + idPlanConsumo + ", idHotel=" + idHotel + "]";
	}
	
	
	
	


}
