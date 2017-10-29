package cem.modelo.entidad;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class Antecedente {
    
    private BigDecimal codigo;
    private String descripcion;
    private Date fechaCaducidad;
    private Blob documento;

    public Antecedente() {
    }

    public Antecedente(BigDecimal codigo, String descripcion,
            Date fechaCaducidad, Blob documento) {
        
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
        this.documento = documento;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Blob getDocumento() {
        return documento;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setDocumento(Blob documento) {
        this.documento = documento;
    }
    
    
}
