package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Reserva implements VOReserva

{
	private BigDecimal idReserva;
	
	
	private Timestamp fechaEntrada;
	
	private Timestamp fechaSalida;

	
	private BigDecimal numeroPersonas;
	
	private BigDecimal idCliente;
	
	private BigDecimal plan_de_pago;
	
	private String estado;
	
	
	public Reserva() 
	{
		this.idReserva = new BigDecimal(0);
		this.fechaEntrada = new Timestamp (0);
		this.fechaSalida = new Timestamp (0);
		this.numeroPersonas = new BigDecimal(0);
		this.idCliente = new BigDecimal(0);
		this.plan_de_pago = new BigDecimal(0);
		this.estado = "";

		
	}
	
	public Reserva(BigDecimal idReserva, Timestamp fechaEntrada,Timestamp fechaSalida,BigDecimal numeroPersonas,BigDecimal idCliente,BigDecimal plan_de_pago,String estado) 
	{
		this.idReserva = idReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroPersonas =  numeroPersonas;
		this.idCliente = idCliente;	
		this.plan_de_pago = plan_de_pago;
		this.estado = estado;
	}

	public BigDecimal getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(BigDecimal idReserva) {
		this.idReserva = idReserva;
	}

	public Timestamp getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Timestamp fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public BigDecimal getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(BigDecimal numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public BigDecimal getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(BigDecimal idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getPlan_de_pago() {
		return plan_de_pago;
	}

	public void setPlan_de_pago(BigDecimal plan_de_pago) {
		this.plan_de_pago = plan_de_pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", numeroPersonas=" + numeroPersonas + ", idCliente=" + idCliente + ", plan_de_pago=" + plan_de_pago
				+ ", estado=" + estado + "]";
	}
	
	
	
	
	



	
	

	
	
	

}
