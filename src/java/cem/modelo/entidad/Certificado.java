package cem.modelo.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Certificado {
    
    private BigDecimal codigo;
    private Date fechaSolicitud;

    public Certificado() {
    }

    public Certificado(BigDecimal codigo, Date fechaSolicitud) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    
}
