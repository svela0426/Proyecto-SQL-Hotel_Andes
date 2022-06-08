package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;
import java.sql.Date;

public class Consulta12 {
    private String nombre;

    private String apellido;

    private String correo;

    private Date fecha_entrada;

    private Date fecha_salida;
	

    public Consulta12(String nombre, String apellido, String correo, Date fecha_entrada, Date fecha_salida) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }

    public Consulta12() {
        this.nombre = "";
        this.apellido =  "";
        this.correo = "";
        this.fecha_entrada = new Date(0);
        this.fecha_salida = new Date(0);
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_entrada() {
        return this.fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return this.fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    @Override
	public String toString() {
		return "[nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida + "]";
	}

}
