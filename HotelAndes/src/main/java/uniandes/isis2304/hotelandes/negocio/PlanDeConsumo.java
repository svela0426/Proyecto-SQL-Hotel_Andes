package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public class PlanDeConsumo implements VOPlanDeConsumo

{
	
	private long idPlanConsumo;

	private String nombre;

	private int costo;

	private Timestamp vigencia;


	
	public PlanDeConsumo(long idPlanConsumo, String nombre, int costo, Timestamp vigencia) 
	{
		this.idPlanConsumo = 0;
		this.nombre = "";
		this.costo = 0;
		this.vigencia = new Timestamp (0);
	}
	
	
	
	public PlanDeConsumo(long idPlanConsumo, String nombre, Timestamp vigencia, int costo) 
	{
		this.idPlanConsumo =idPlanConsumo ;
		this.nombre = nombre;
		this.costo = costo;
		this.vigencia = vigencia;
	}



	public long getIdPlanConsumo() {
		return idPlanConsumo;
	}



	public void setIdPlanConsumo(long idPlanConsumo) {
		this.idPlanConsumo = idPlanConsumo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCosto() {
		return costo;
	}



	public void setCosto(int costo) {
		this.costo = costo;
	}



	public Timestamp getVigencia() {
		return vigencia;
	}



	public void setVigencia(Timestamp vigencia) {
		this.vigencia = vigencia;
	}



	@Override
	public String toString() {
		return "PlanDeConsumo [idPlanConsumo=" + idPlanConsumo + ", nombre=" + nombre + ", costo=" + costo
				+ ", vigencia=" + vigencia + "]";
	}
	
	
	
	
}
