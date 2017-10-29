package cem.modelo.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Programa {
    
    private BigDecimal codigo;
    private String nombre;
    private Date fechaInicio;
    private Date fechaTermino;
    private int valor;
    private int tipoPrograma;
    private String estado;

    public Programa() {
    }

    public Programa(BigDecimal codigo, String nombre, Date fechaInicio,
            Date fechaTermino, int valor, int tipoPrograma, String estado) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.valor = valor;
        this.tipoPrograma = tipoPrograma;
        this.estado = estado;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public int getValor() {
        return valor;
    }

    public int getTipoPrograma() {
        return tipoPrograma;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setTipoPrograma(int tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
