package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class ClienteActivo  implements VOClienteActivo
{
	private BigDecimal idCliente;

	private BigDecimal idReserva;
	
	
	public ClienteActivo() 
	{
		this.idCliente = new BigDecimal(0);
		this.idReserva = new BigDecimal(0);
	}
	/*
	public ClienteActivo(long idCliente, long idReserva) 
	{
		this.idCliente = idCliente;
		this.idReserva = idReserva;
	}
	*/
	public ClienteActivo(BigDecimal idCliente, BigDecimal idReserva) 
	{
		this.idCliente = idCliente;
		this.idReserva = idReserva;
	}

	public BigDecimal getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(BigDecimal idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(BigDecimal idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return "ClienteActivo [idCliente=" + idCliente + ", idReserva=" + idReserva + "]";
	}
	

}
