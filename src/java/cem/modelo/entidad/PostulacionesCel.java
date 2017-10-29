package cem.modelo.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class PostulacionesCel {
    
    private BigDecimal codigo;
    private Date fechaInscripcion;
    private String estado;

    public PostulacionesCel() {
    }

    public PostulacionesCel(BigDecimal codigo, Date fechaInscripcion, String estado) {
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
