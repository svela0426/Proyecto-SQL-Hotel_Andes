package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Date;

public class Consulta9 {
    private BigDecimal id;

	private BigDecimal idServicio;

    private Date fecha_solicitud;
	
	private BigDecimal consumo;
	


    public Consulta9(BigDecimal id, BigDecimal idServicio, Date fecha_solicitud, BigDecimal consumo) {
        this.id = id;
        this.idServicio = idServicio;
        this.fecha_solicitud = fecha_solicitud;
        this.consumo = consumo;
    }

    public Consulta9() {
        this.id = new BigDecimal(0);
        this.idServicio = new BigDecimal(0);
        this.fecha_solicitud = new Date(0);
        this.consumo = new BigDecimal(0);
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public BigDecimal getConsumo() {
        return this.consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }
    

    @Override
	public String toString() {
		return "[id=" + id + ", idServicio=" + idServicio + ", fecha_solicitud=" + fecha_solicitud + ", total=" + consumo + "]";
	}

}
