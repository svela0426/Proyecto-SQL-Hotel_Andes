package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Consulta10;
import uniandes.isis2304.hotelandes.negocio.Consulta12;
import uniandes.isis2304.hotelandes.negocio.Consulta9;

public class SQLConsultas {
    private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes ph;


	public SQLConsultas (PersistenciaHotelAndes ph)
	{
		this.ph = ph;
	}

    public List<Consulta9> consulta9(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT usi.id,ser.idservicio,ser.fecha_solicitud,count(ser.idservicio) as consumo FROM a_servicio_solicitado ser, a_cuenta_cargada cue,a_habitacion_reservada re, a_reserva bas,a_usuario usi where ser.idservicio=cue.idservicio and cue.idcuenta=re.idcuenta and re.idreserva=bas.idreserva and bas.idcliente=usi.id and ser.fecha_solicitud BETWEEN '11/02/12' AND '16/12/12' group by usi.id,ser.idservicio,ser.fecha_solicitud order by count(ser.idservicio)desc");
		q.setResultClass(Consulta9.class);
		return (List<Consulta9>) q.executeList();
    }

	public List<Consulta10> consulta10(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT usi.id,ser.idservicio,ser.fecha_solicitud FROM a_servicio_solicitado ser, a_cuenta_cargada cue,a_habitacion_reservada re, a_reserva bas,a_usuario usi where ser.idservicio=cue.idservicio and cue.idcuenta=re.idcuenta and re.idreserva=bas.idreserva and bas.idcliente=usi.id and ser.fecha_solicitud BETWEEN '11/02/12' AND '16/12/12' group by usi.id,ser.idservicio,ser.fecha_solicitud");
		q.setResultClass(Consulta10.class);
		return (List<Consulta10>) q.executeList();
    }
/* 
	public List<Consulta11> consulta11(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT  cu.IDSERVICIO ,ser.fecha_solicitud, COUNT(cu.IDSERVICIO) as demanda FROM a_cuenta_cargada cu , a_servicio_solicitado ser where ser.idservicio=cu.idservicio GROUP BY  cu.IDSERVICIO ,ser.fecha_solicitud order by count(cu.IDSERVICIO) asc FETCH NEXT 5 ROWS ONLY");
		q.setResultClass(Consulta11.class);
		return (List<Consulta11>) q.executeList();
    }
*/
	public List<Consulta12> consulta12(PersistenceManager pm){
        Query q = pm.newQuery(SQL, "SELECT userr.nombre,userr.apellido,userr.correo,re.fechaentrada,re.fechasalida FROM a_reserva re, a_habitacion_reservada hab, A_CUENTA_CARGADA cuu,  a_servicio ser,a_usuario userr where re.idreserva=hab.idreserva and hab.idcuenta=cuu.idcuenta and cuu.idservicio=ser.idservicio and ser.costo >300000 and ser.nombre LIKE'spa%' and userr.id=re.idcliente");
		q.setResultClass(Consulta12.class);
		return (List<Consulta12>) q.executeList();
    }
}
