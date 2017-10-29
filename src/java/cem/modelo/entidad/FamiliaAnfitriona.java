package cem.modelo.entidad;

import java.util.Date;

public class FamiliaAnfitriona extends Persona {
    
    private Short cantidadIntegrantes;
    private String estado;

    public FamiliaAnfitriona() {
    }

    public FamiliaAnfitriona(Short cantidadIntegrantes,
            String estado) {
        
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
    }

    public FamiliaAnfitriona(Short cantidadIntegrantes, String estado,
            int rutPersona, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        super(rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
    }

    public Short getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setCantidadIntegrantes(Short cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return
                "Rut                     : " + getRut() + "\n" +
                "Jefe de familia         : " + getNombreCompleto() + "\n" +
                "Fecha de nacimiento     : " + getFechaNacimiento() + "\n" +
                "Domicilio               : " + getDomicilio() + "\n"+
                "Ciudad                  : " + getCiudad() + "\n"+
                "País                    : " + getPais() + "\n"+
                "E-mail                  : " + getCorreo() + "\n"+
                "Teléfono                : " + getTelefono() + "\n"+
                "Cantidad de integrantes : " + cantidadIntegrantes + "\n" +
                "Estado de inscripción   : " + estado + "\n";
    }
    
    
}
