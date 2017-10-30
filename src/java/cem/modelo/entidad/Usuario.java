package cem.modelo.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Usuario {
    
    private long codigo;
    private String nombre;
    private String contrasena;
    private Date fechaRegistro;

    public Usuario() {
    }

    public Usuario(long codigo, String nombre, String contrasena,
            Date fechaRegistro) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }    
    
}
