package cem.modelo.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Calificacion {
    
    private BigDecimal codigo;
    private Date fechaCalificacion;
    private BigDecimal nota;

    public Calificacion() {
    }

    public Calificacion(BigDecimal codigo, Date fechaCalificacion, BigDecimal nota) {
        this.codigo = codigo;
        this.fechaCalificacion = fechaCalificacion;
        this.nota = nota;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
    
    
}
