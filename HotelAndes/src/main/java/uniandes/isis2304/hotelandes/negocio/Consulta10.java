package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Date;

public class Consulta10 {

	private BigDecimal idServicio;

    private Date fecha_solicitud;
	

    public Consulta10(BigDecimal idServicio, Date fecha_solicitud) {
        this.idServicio = idServicio;
        this.fecha_solicitud = fecha_solicitud;
    }

    public Consulta10() {
        this.idServicio = new BigDecimal(0);
        this.fecha_solicitud = new Date(0);
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

    

    @Override
	public String toString() {
		return "[idServicio=" + idServicio + ", fecha_solicitud=" + fecha_solicitud + "]";
	}

}
