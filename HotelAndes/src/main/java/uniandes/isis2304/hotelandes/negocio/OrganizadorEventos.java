package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class OrganizadorEventos extends Usuario implements VOOrganizadorEventos{
    private BigDecimal planDePagoAcordado;

    public OrganizadorEventos(){
        super();
        this.planDePagoAcordado = new BigDecimal(0);
    }
    public OrganizadorEventos(BigDecimal idUsuario,BigDecimal numero,String nombre,String apellido,String correo,BigDecimal planDePagoAcordado) {
        super(idUsuario, numero, nombre, apellido, correo);
        this.planDePagoAcordado = planDePagoAcordado;
    }


    public BigDecimal getPlanDePagoAcordado() {
        return this.planDePagoAcordado;
    }

    public void setPlanDePagoAcordado(BigDecimal planDePagoAcordado) {
        this.planDePagoAcordado = planDePagoAcordado;
    }

    @Override
	public String toString() {
		return "OrganizadorEventos [idUsuario=" + getIdUsuario() + ", numero=" + getNumero() + ", nombre=" + getNombre() + ", apellido="
				+ getApellido() + ", correo=" + getCorreo() + ", planDePagoAcordado="+planDePagoAcordado+"]";
	}
    
}
