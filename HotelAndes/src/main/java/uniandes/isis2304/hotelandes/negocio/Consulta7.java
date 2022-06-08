package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Consulta7 {
    private String nombre;

	private BigDecimal idCliente;
	
	private BigDecimal total;
	

    public Consulta7(String nombre, BigDecimal idCliente, BigDecimal total) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.total = total;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
	public String toString() {
		return "[nombre=" + nombre + ", idCliente=" + idCliente + ", total=" + total + "]";
	}

}
