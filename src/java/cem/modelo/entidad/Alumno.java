package cem.modelo.entidad;

import java.util.Date;

public class Alumno extends Persona {
    
    private long numeroMatricula;
    private Date fechaMatricula;

    public Alumno() {
    }

    public Alumno(long numeroMatricula, Date fechaMatricula) {
        this.numeroMatricula = numeroMatricula;
        this.fechaMatricula = fechaMatricula;
    }

    public Alumno(long numeroMatricula, Date fechaMatricula, int rutPersona,
            String nombreCompleto, Date fechaNacimiento, String domicilio,
            String ciudad, String pais, String correo, String telefono,
            String tipo) {
        
        super (rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        this.numeroMatricula = numeroMatricula;
        this.fechaMatricula = fechaMatricula;
    }

    public long getNumeroMatricula() {
        return numeroMatricula;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setNumeroMatricula(long numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
    
    
}
