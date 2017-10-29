package cem.modelo.entidad;

import java.math.BigDecimal;

public class Asignatura {
    
    private BigDecimal codigo;
    private String nombreAsignatura;
    private String descripcion;
    private Long cupos;

    public Asignatura() {
    }

    public Asignatura(BigDecimal codigo, String nombreAsignatura,
            String descripcion, Long cupos) {
        
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
        this.descripcion = descripcion;
        this.cupos = cupos;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getCupos() {
        return cupos;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCupos(Long cupos) {
        this.cupos = cupos;
    }
    
    
}
