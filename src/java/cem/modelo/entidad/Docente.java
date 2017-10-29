package cem.modelo.entidad;

import java.util.Date;

public class Docente extends Persona {
    
    private int rutPersona;
    private String estado;
    private String observaciones;
    
    public Docente() {
    }

    public Docente(int rutPersona, String estado, String observaciones) {
        this.rutPersona = rutPersona;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Docente(int rutPersona, String estado, String observaciones,
            int rut, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        super(rut, nombreCompleto, fechaNacimiento, domicilio, ciudad, pais,
                correo, telefono, tipo);
        this.rutPersona = rutPersona;
        this.estado = estado;
        this.observaciones = observaciones;
    }
    
    public int getRutPersona() {
        return rutPersona;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setRutPersona(int rutPersona) {
        this.rutPersona = rutPersona;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
