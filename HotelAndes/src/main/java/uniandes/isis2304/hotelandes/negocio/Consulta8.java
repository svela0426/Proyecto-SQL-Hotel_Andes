package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Date;

public class Consulta8 {

    private BigDecimal idServicio;

	private Date fecha_solicitud;
	
	private BigDecimal demanda;
	


    public Consulta8() {
        this.idServicio = new BigDecimal(0);
        this.fecha_solicitud = new Date(0);
        this.demanda = new BigDecimal(0);
    }

    public Consulta8(BigDecimal idServicio, Date fecha_solicitud, BigDecimal demanda) {
        this.idServicio = idServicio;
        this.fecha_solicitud = fecha_solicitud;
        this.demanda = demanda;
    }
    

    public BigDecimal getIdServicio() {
        return this.idServicio;
    }

    public void setIdServicio(BigDecimal idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFecha_solicitud() {
        return this.fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public BigDecimal getDemanda() {
        return this.demanda;
    }

    public void setDemanda(BigDecimal demanda) {
        this.demanda = demanda;
    }

    @Override
	public String toString() {
		return "[idServicio=" + idServicio + ", fecha_solicitud=" + fecha_solicitud +", demanda=" + demanda + "]";
	}

}
