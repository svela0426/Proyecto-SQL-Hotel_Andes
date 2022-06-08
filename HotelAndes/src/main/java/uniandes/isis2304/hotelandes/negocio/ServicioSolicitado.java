package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ServicioSolicitado implements VOServicioSolicitado
{
	private BigDecimal idServicio;
	
	private BigDecimal numpersonas;
	
	private BigDecimal Costo;
	
	private Timestamp fecha_solicitud;
	
	
	
	public ServicioSolicitado() 
	{
		this.idServicio = new BigDecimal(0);
		this.numpersonas = new BigDecimal(0);
		this.Costo = new BigDecimal(0);
		this.fecha_solicitud = new Timestamp (0);
	}
	
	
	public ServicioSolicitado(BigDecimal idServicio,BigDecimal numpersonas,BigDecimal Costo,Timestamp fecha_solicitud) 
	{
		this.idServicio = idServicio;
		this.numpersonas = numpersonas;
		this.Costo = Costo;	
		this.fecha_solicitud = fecha_solicitud;
	}
	
	public Timestamp getFecha_solicitud() {
		
		return fecha_solicitud ; 
	}
	
	public void setFecha_solicitud(Timestamp fechaSalida) {
		this.fecha_solicitud = fechaSalida;
	}
	
	


	public BigDecimal getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(BigDecimal idServicio) {
		this.idServicio = idServicio;
	}


	public BigDecimal getNumpersonas() {
		return numpersonas;
	}


	public void setNumpersonas(BigDecimal numpersonas) {
		this.numpersonas = numpersonas;
	}


	public BigDecimal getCosto() {
		return Costo;
	}


	public void setCosto(BigDecimal costo) {
		Costo = costo;
	}


	@Override
	public String toString() {
		return "ServicioSolicitado [idServicio=" + idServicio + ", numpersonas=" + numpersonas + ", Costo=" + Costo
				+ ", fecha_solicitud=" + fecha_solicitud + "]";
	}



	

	
	

}
