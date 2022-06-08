package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public interface VOPlanDePagoAcordado {
    
    public long getId();

    public String getTipoHabitaciones();

    public int getNumeroHabitaciones();


    public int getNumeroPersonas();

    public Timestamp getFechaInicio();

    public Timestamp getFechaSalida();

    public String getEstado();
}
