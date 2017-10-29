
/*
    Actualmente trabajando en el crud mediante procedimientos almacenados.
*/


package cem.controlador.dao;

import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoEntidadesPA {
    
    private Connection c;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public DaoEntidadesPA() {
        this.c = null;
        this.ps = null;
        this.cs = null;
        this.rs = null;
    }
    
    /*public boolean insertar(Object objInsertar) {
        
        if (objInsertar instanceof Persona) {
            
        }
        
        
    }*/
    
    public boolean alumnoInsertar(Alumno objAlumno) throws SQLException {
        boolean resultado = false;
        String sql = "{call CEM.PERSONA_INSERTAR(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            c = Conexion.abrir();
            cs = c.prepareCall(sql);
            
            cs.setInt   (1, objAlumno.getRut());
            cs.setString(2, objAlumno.getNombreCompleto());
            cs.setDate  (3, (Date) objAlumno.getFechaNacimiento());
            cs.setString(4, objAlumno.getDomicilio());
            cs.setString(5, objAlumno.getCiudad());
            cs.setString(6, objAlumno.getPais());
            cs.setString(7, objAlumno.getCorreo());
            cs.setString(8, objAlumno.getTelefono());
            cs.setString(9, objAlumno.getTipo());
            
            cs.execute();
            
            rs = cs.getResultSet();
            resultado = rs.getBoolean("resultado");
        }
        catch (SQLException se) {
            c.rollback();
        }
        finally {
            Conexion.cerrar(c, null, cs, rs);
        }
        return resultado;
    }
    
    public boolean buscar() {
        throw new UnsupportedOperationException("No implementado.");
    }
    
    public boolean eliminar() {
        throw new UnsupportedOperationException("No implementado.");
    }
    
    public boolean modificar() {
        throw new UnsupportedOperationException("No implementado.");
    }
}
