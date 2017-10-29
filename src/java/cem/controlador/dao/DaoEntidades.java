package cem.controlador.dao;

import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEntidades {
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    public DaoEntidades() {
        this.c = null;
        this.ps = null;
        this.rs = null;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" :Persona ">
    
    public boolean insertarPersona(int rut, String nombreCompleto,
            Date fechaNacimiento, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo) {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PERSONA (RUT, NOMBRE_COMPLETO, "
                + "FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, CORREO, "
                + "TELEFONO, TIPO) VALUES (?, ?, ?, ?, ? ,? ,? ,? , ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
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
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return resultado;
    }
    
    public boolean comprobarRutExistente(int rut) {
        boolean resultado = false;
        String sql = "SELECT * FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rut);
            rs = ps.executeQuery(sql);
            if (rs.getRow() > 0) {
                resultado = true;
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return resultado;
    }
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" :Alumno ">
    /*
    public boolean insertarAlum(Alumno objAlumno)
            throws SQLException {
        
        boolean resultado = false;
        // Si el rut no está en la base de datos, comienza la inserción.
        if (!comprobarRutExistente(objAlumno.getRut())) {
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
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    
                    ps.setInt (1, objAlumno.getRut());
                    ps.setLong(2, objAlumno.getNumeroMatricula());
                    ps.setDate(3, (Date) objAlumno.getFechaMatricula());
                    
                    ps.executeUpdate();
                    
                    ps.close();
                    c.close();
                    conexion.cerrar();
                     
                    resultado = true;
                }
                catch (SQLException se) {
                    // Controlar excepción.
                }
            }
        }
        return resultado;
    }
    */
    public ArrayList<Alumno> listarAlumnos()
            throws SQLException {
        
        ArrayList<Alumno> listado = new ArrayList<>();
        String sql = "SELECT * FROM CEM.ALUMNO;";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
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
            
            ps.close();
            rs.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            c.rollback();
        }
        /*finally {
            conexion.cerrar(ps, rs);
            //Conexion.cerrar(c, ps, null, rs);
        }*/
        return listado;
    }
    
    /**
     * 
     * @param objAlumno Objeto tipo Alumno con que contiene, además, los datos
     *                  de su clase padre Persona.
     * @return -2, Si el rut ya existe en la base de datos.
     *         -1, Si no se logró insertar la persona.
     *          0, Si no se logró insertar el alumno.
     *          1, Si toda la inserción fue correcta.
     */
    public int insertarAlumno(Alumno objAlumno) {
        int resultado = 0;
        // Si el rut no está registrado en la base de datos, entonces se
        // procede con la inserción.
        if (!comprobarRutExistente(objAlumno.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objAlumno.getFechaNacimiento().getTime());
            // Antes de insertar a un alumno, deben insertarse los datos de la
            // persona y, si esta se inserta correctamente, se procede con la
            // inserción del alumno.
            if (insertarPersona(
                    objAlumno.getRut(),
                    objAlumno.getNombreCompleto(),
                    fechaNacimiento,
                    objAlumno.getDomicilio(),
                    objAlumno.getCiudad(),
                    objAlumno.getPais(),
                    objAlumno.getCorreo(),
                    objAlumno.getTelefono(),
                    objAlumno.getTipo())) {
                
                String sql = "INSERT INTO CEM.ALUMNO (RUT_PERSONA, "
                        + "NUMERO_MATRICULA, FECHA_MATRICULA)"
                        + "VALUES (?, ?, ?)";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    Date fechaMatricula = new java.sql.Date(
                            objAlumno.getFechaNacimiento().getTime());
                    ps.setInt (1, objAlumno.getRut());
                    ps.setLong(2, objAlumno.getNumeroMatricula());
                    ps.setDate(3, fechaMatricula);
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException ex) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Programa : Completo ">
        
    public boolean insertarPrograma(Programa objPrograma) {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PROGRAMA (CODIGO, NOMBRE, FECHA_INICIO, "
                + "FECHA_TERMINO, VALOR, ESTADO) "
                + "VALUES (? ,?, ?, ?, ?, ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            
            Date fechaInicio = new java.sql.Date(
                    objPrograma.getFechaInicio().getTime());
            
            Date fechaTermino = new java.sql.Date(
                    objPrograma.getFechaTermino().getTime());
            
            ps.setLong  (1, objPrograma.getCodigo());
            ps.setString(2, objPrograma.getNombre());
            ps.setDate  (3, fechaInicio);
            ps.setDate  (4, fechaTermino);
            ps.setInt   (5, objPrograma.getValor());
            ps.setString(6, objPrograma.getEstado());
            
            ps.executeUpdate();
            
            ps.close();
            c.close();
            conexion.cerrar();
            
            resultado = true;
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return resultado;
    }
    
    public long ultimoCodigoPrograma()
            throws SQLException {
        
        long codigo = -1;
        String sql = "SELECT MAX(CODIGO) FROM CEM.PROGRAMA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                codigo = rs.getLong(1);
            }
            
            ps.close();
            rs.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        /*finally {
            conexion.cerrar(ps, rs);
            //Conexion.cerrar(c, ps, null, rs);
        }*/
        return codigo;
    }
    
    public ArrayList<Programa> listarProgramas() {
        ArrayList<Programa> listado = null;
        String sql = "SELECT * FROM CEM.PROGRAMA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            listado = new ArrayList<>();
            while (rs.next()) {
                listado.add(new Programa(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6)
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    public boolean eliminarPrograma(long codigo) {
        boolean resultado = false;
        String sql = "DELETE FROM CEM.PROGRAMA WHERE CODIGO = ?";
        try {
            Conexion conexion = new Conexion();
            Connection c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setLong(1, codigo);
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        finally {
            // Desde acá debería cerrarse la conexión actual.
        }
        return resultado;
    }
    
    public boolean modificarPrograma(Programa objPrograma) {
        boolean resultado = false;
        String sql = "UPDATE CEM.PROGRAMA SET NOMBRE = ?, FECHA_INICIO = ?, "
                + "FECHA_TERMINO = ?, VALOR = ?, ESTADO = ? WHERE CODIGO = ?";
        
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            
            Date fechaInicio = new java.sql.Date(
                    objPrograma.getFechaInicio().getTime());
            
            Date fechaTermino = new java.sql.Date(
                    objPrograma.getFechaTermino().getTime());
            
            ps.setString(1, objPrograma.getNombre());
            ps.setDate  (2, fechaInicio);
            ps.setDate  (3, fechaTermino);
            ps.setInt   (4, objPrograma.getValor());
            ps.setString(5, objPrograma.getEstado());
            ps.setLong  (6, objPrograma.getCodigo());
            
            ps.executeUpdate();
            
            ps.close();
            c.close();
            conexion.cerrar();
            
            resultado = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public Programa buscarPrograma(long codigo) {
        Programa programa = null;
        String sql = "SELECT * FROM CEM.PROGRAMA WHERE CODIGO = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                programa = new Programa(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6)
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return programa;
    }
    
    //</editor-fold>
}
