package cem.controlador.dao;

import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEntidades {
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public DaoEntidades() {
        this.c = null;
        this.ps = null;
        this.rs = null;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Persona ">
    
    public boolean insertarPersona(int rut, String nombreCompleto,
            Date fechaNacimiento, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo)
            throws SQLException {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PERSONA (RUT, NOMBRE_COMPLETO, "
                + "FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, CORREO, "
                + "TELEFONO, TIPO) VALUES (?, ?, ?, ?, ? ,? ,? ,? ,?);";
        try {
            c = Conexion.abrir();
            ps = c.prepareStatement(sql);
            
            ps.setInt   (1, rut);
            ps.setString(2, nombreCompleto);
            ps.setDate  (3, fechaNacimiento);
            ps.setString(4, domicilio);
            ps.setString(5, ciudad);
            ps.setString(6, pais);
            ps.setString(7, correo);
            ps.setString(8, telefono);
            ps.setString(9, tipo);
            
            ps.executeUpdate();
            resultado = true;
        }
        catch (SQLException se) {
            c.rollback();
        }
        finally {
            Conexion.cerrar(c, ps, null, null);
        }
        return resultado;
    }
    
    public boolean buscarRut(int rut)
            throws SQLException {
        
        boolean resultado = false;
        String sql = "SELECT * FROM CEM.PERSONA WHERE RUT = ?;";
        try {
            c = Conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rut);
            rs = ps.executeQuery(sql);
            if (rs.getRow() > 0) {
                resultado = true;
            }
        }
        catch (SQLException se) {
            c.rollback();
        }
        finally {
            Conexion.cerrar(c, ps, null, rs);
        }
        return resultado;
    }
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Alumno ">
    
    public boolean insertarAlumno(Alumno objAlumno)
            throws SQLException {
        
        boolean resultado = false;
        // Si el rut no está en la base de datos, comienza la inserción.
        if (!buscarRut(objAlumno.getRut())) {
            // Antes de insertar el alumno, debe insertarse la persona, por lo
            // tanto, si se inserta la persona correctamente, se procede a
            // insertar el alumno.
            if (insertarPersona(objAlumno.getRut(),
                    objAlumno.getNombreCompleto(),
                    (Date) objAlumno.getFechaNacimiento(),
                    objAlumno.getDomicilio(), objAlumno.getCiudad(),
                    objAlumno.getPais(), objAlumno.getCorreo(),
                    objAlumno.getTelefono(), objAlumno.getTipo())) {
            
                String sql = "INSERT INTO CEM.ALUMNO (RUT_PERSONA,"
                        + "NUMERO_MATRICULA, FECHA_MATRICULA)"
                        + "VALUES (? , ?, ?);";
                try {
                    c = Conexion.abrir();
                    ps = c.prepareStatement(sql);
                    
                    ps.setInt (1, objAlumno.getRut());
                    ps.setLong(2, objAlumno.getNumeroMatricula());
                    ps.setDate(3, (Date) objAlumno.getFechaMatricula());
                    
                    ps.executeUpdate();
                    resultado = true;
                }
                catch (SQLException se) {
                    c.rollback();
                }
                finally {
                    Conexion.cerrar(c, ps, null, null);
                }
            }
        }
        return resultado;
    }
    
    public ArrayList<Alumno> listarAlumnos()
            throws SQLException {
        
        ArrayList<Alumno> listado = new ArrayList<>();
        String sql = "SELECT * FROM CEM.ALUMNO;";
        try {
            c = Conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                rs.getInt("RUT_PERSONA");
                rs.getLong("NUMERO_MATRICULA");
                rs.getDate("FECHA_MATRICULA");
                listado.add(new Alumno(
                        rs.getLong("NUMERO_MATRICULA"),
                        rs.getDate("FECHA_MATRICULA")
                ));
            }
        }
        catch (SQLException se) {
            c.rollback();
        }
        finally {
            Conexion.cerrar(c, ps, null, rs);
        }
        return listado;
    }
    
    //</editor-fold>
    
}
