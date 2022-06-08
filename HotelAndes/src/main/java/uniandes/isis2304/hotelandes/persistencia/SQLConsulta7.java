package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Consulta7;

public class SQLConsulta7 {
    private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;


	public SQLConsulta7 (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}

    public List<Consulta7> consulta7(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT us.nombre,re.idcliente,SUM (cu.total) total FROM a_reserva re ,a_habitacion_reservada hab, a_cuenta cu,a_usuario us where hab.idreserva=re.idreserva and hab.idcuenta=cu.idcuenta and us.id=re.idcliente GROUP BY (us.nombre,re.idcliente) order by total desc");
		q.setResultClass(Consulta7.class);
		return (List<Consulta7>) q.executeList();
    }
}
