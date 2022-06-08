package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class RolUsuario implements VORolUsuario{
    private BigDecimal idUsuario;
    private String rol;


    public RolUsuario(){
        this.idUsuario = new BigDecimal(0);
        this.rol = "";    
    }
    public RolUsuario(BigDecimal idUsuario, String rol){
        this.idUsuario = idUsuario;
        this.rol = rol;
        
    }
    
    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setidUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
	public String toString() {
		return "RolUsuario [idUsuario=" + idUsuario + ", rol=" + rol  + "]";
	}

}
