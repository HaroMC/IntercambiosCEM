package cem.modelo.entidad;

import java.util.Date;

public class FamiliaAnfitriona extends Persona {
    
    private int rutPersona;
    private Short cantidadIntegrantes;
    private String estado;

    public FamiliaAnfitriona() {
    }

    public FamiliaAnfitriona(int rutPersona, Short cantidadIntegrantes,
            String estado) {
        
        this.rutPersona = rutPersona;
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
    }

    public FamiliaAnfitriona(int rutPersona, Short cantidadIntegrantes,
            String estado, int rut, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        super(rut, nombreCompleto, fechaNacimiento, domicilio, ciudad, pais,
                correo, telefono, tipo);
        this.rutPersona = rutPersona;
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
    }

    public int getRutPersona() {
        return rutPersona;
    }

    public Short getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setRutPersona(int rutPersona) {
        this.rutPersona = rutPersona;
    }

    public void setCantidadIntegrantes(Short cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
