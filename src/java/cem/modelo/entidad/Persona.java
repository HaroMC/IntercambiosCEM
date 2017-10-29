package cem.modelo.entidad;

import java.util.Date;

public abstract class Persona {

    private int rut;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String domicilio;
    private String ciudad;
    private String pais;
    private String correo;
    private String telefono;
    private String tipo;

    public Persona() {
    }

    public Persona(int rut, String nombreCompleto, String domicilio,
            String ciudad, String pais, String correo, String telefono,
            String tipo) {

        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }
    
    public Persona(int rut, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {

        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public int getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
