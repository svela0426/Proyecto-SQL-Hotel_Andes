package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Servicio implements VOServicio
{
	
	private BigDecimal idServicio;
	
	private String nombre;

	private String descripcion;

	private BigDecimal area;

	private BigDecimal costo;
	
	
	
	public Servicio() 
	{
		this.idServicio = new BigDecimal(0);
		this.nombre = "";
		this.descripcion = "";
		this.area = new BigDecimal(0);
		this.costo = new BigDecimal(0);
	}
	/*
	public Servicio(BigDecimal idServicio, String nombre,String descripcion,String area, int costo) 
	{
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.area = area;
		this.costo = costo;
		}
		*/
	public Servicio(BigDecimal idServicio, String nombre,String descripcion,BigDecimal area, BigDecimal costo) 
	{
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.area = area;
		this.costo = costo;
		}

	public BigDecimal getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(BigDecimal idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", area="
				+ area + "]";
	}
	
	
	
	



}
