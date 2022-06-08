package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Consulta8;

public class SQLConsulta8 {
    private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;


	public SQLConsulta8 (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}

    public List<Consulta8> consulta8(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT  cu.IDSERVICIO ,ser.fecha_solicitud, COUNT(cu.IDSERVICIO) as demanda FROM a_cuenta_cargada cu , a_servicio_solicitado ser where ser.idservicio=cu.idservicio GROUP BY  cu.IDSERVICIO ,ser.fecha_solicitud order by count(cu.IDSERVICIO) asc FETCH NEXT 5 ROWS ONLY");
		q.setResultClass(Consulta8.class);
		return (List<Consulta8>) q.executeList();
    }
}
