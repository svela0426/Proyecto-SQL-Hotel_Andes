package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public class PlanDePagoAcordado implements VOPlanDePagoAcordado {
    private long id;
    private String tipoHabitaciones;
    private int numeroHabitaciones;
    private int numeroPersonas;
    private Timestamp fechaInicio;
    private Timestamp fechaSalida;
    private String estado;

    public PlanDePagoAcordado(){
        this.id = 0;
        this.tipoHabitaciones = "";
        this.numeroHabitaciones = 0;
        this.numeroPersonas = 0;
        this.fechaInicio = new Timestamp(0);
        this.fechaSalida = new Timestamp(0);
        this.estado = "";
    }


    public PlanDePagoAcordado(long id, String tipoHabitaciones, int numeroHabitaciones, int numeroPersonas, Timestamp fechaInicio, Timestamp fechaSalida, String estado)
    {
        this.id = id;
        this.tipoHabitaciones = tipoHabitaciones;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroPersonas = numeroPersonas;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoHabitaciones() {
        return this.tipoHabitaciones;
    }

    public void setTipoHabitaciones(String tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }

    public int getNumeroHabitaciones() {
        return this.numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }


    public int getNumeroPersonas() {
        return this.numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Timestamp getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


	@Override
	public String toString() {
		return "PlanDePagoAcordado [id=" + id + ", tipoHabitaciones=" + tipoHabitaciones + ", numeroHabitaciones="
				+ numeroHabitaciones + ", numeroPersonas=" + numeroPersonas + ", fechaInicio=" + fechaInicio
				+ ", fechaSalida=" + fechaSalida + ", estado=" + estado + "]";
	}


    
    
    
    
    
}
