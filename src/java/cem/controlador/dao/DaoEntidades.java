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
    
    // Como persona es una clase abstracta, los métodos crud de persona no
    // serán accesibles fuera de esta clase.
    // Eliminar persona es la única exceptión, debido a que es posible eliminar
    // una persona por su rut y, gracias al CASCADE CONSTRAINT en la base de
    // datos, se eliminará tambíen el Alumno, CEL, Docente o FamiliaAnfitriona
    // enlazada.
    
    
    //<editor-fold defaultstate="collapsed" desc=" Persona : Completo ">
    
    private boolean insertarPersona(int rut, String nombreCompleto,
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
    
    private boolean comprobarRutExistente(int rut) {
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
    
    public boolean eliminarPersona(int rut) {
        boolean resultado = false;
        String sql = "DELETE FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rut);
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
    
    private boolean modificarPersona(int rut, String nombreCompleto,
            Date fechaNacimiento, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo) {
        
        boolean resultado = false;
        String sql = "UPDATE CEM.PERSONA SET NOMBRE_COMPLETO = ?, "
                + "FECHA_NACIMIENTO = ?, DOMICILIO = ?, CIUDAD = ?, PAIS = ?, "
                + "CORREO = ?, TELEFONO = ?, TIPO = ? WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, nombreCompleto);
            ps.setDate  (2, fechaNacimiento);
            ps.setString(3, domicilio);
            ps.setString(4, ciudad);
            ps.setString(5, pais);
            ps.setString(6, correo);
            ps.setString(7, telefono);
            ps.setString(8, tipo);
            ps.setInt   (9, rut);
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
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Alumno : Completo ">
    
    public ArrayList<Alumno> listarAlumnos() {
        ArrayList<Alumno> listado = new ArrayList<>();
        String sql = "SELECT NUMERO_MATRICULA, FECHA_MATRICULA, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, "
                + "CORREO, TELEFONO, TIPO FROM CEM.ALUMNO "
                + "INNER JOIN CEM.PERSONA ON ALUMNO.RUT_PERSONA = PERSONA.RUT";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                listado.add(new Alumno(
                        // Datos de alumno:
                        rs.getLong(1),
                        rs.getDate(2),
                        // Datos de persona:
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        null
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
    
    /**
     * 
     * @param objAlumno Objeto tipo Alumno con que contiene, además, los datos
     *                  de su clase padre Persona.
     * @return (-2) Si el rut ya existe en la base de datos.<br>
     *         (-1) Si no se logró insertar la persona.<br>
     *         ( 0) Si no se logró insertar el alumno.<br>
     *         ( 1) Si toda la inserción fue correcta.
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
    
    public int modificarAlumno(Alumno objAlumno) {
        int resultado = 0;
        if (comprobarRutExistente(objAlumno.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objAlumno.getFechaNacimiento().getTime());
            if (modificarPersona(
                    objAlumno.getRut(),
                    objAlumno.getNombreCompleto(),
                    fechaNacimiento,
                    objAlumno.getDomicilio(),
                    objAlumno.getCiudad(),
                    objAlumno.getPais(),
                    objAlumno.getCorreo(),
                    objAlumno.getTelefono(),
                    objAlumno.getTipo())) {
                resultado = 1;
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
    
    public Alumno buscarAlumno(int rutPersona) {
        Alumno alumno = null;
        String sql = "SELECT NUMERO_MATRICULA, FECHA_MATRICULA, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, "
                + "CORREO, TELEFONO, TIPO FROM CEM.ALUMNO "
                + "INNER JOIN CEM.PERSONA ON ALUMNO.RUT_PERSONA = PERSONA.RUT "
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rutPersona);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                alumno = new Alumno(
                        rs.getLong(1),
                        rs.getDate(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        null
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return alumno;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Programa : Completo ">
        
    public boolean insertarPrograma(Programa objPrograma) {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PROGRAMA (CODIGO, NOMBRE, FECHA_INICIO, "
                + "FECHA_TERMINO, VALOR, ESTADO) VALUES (? ,?, ?, ?, ?, ?)";
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
    
    public long ultimoCodigoPrograma() {
        
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
        
    //<editor-fold defaultstate="collapsed" desc=" Familia Anfitriona : Completo ">
    
    public int insertarFamilia(FamiliaAnfitriona objFamilia) {
        int resultado = 0;
        if (!comprobarRutExistente(objFamilia.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objFamilia.getFechaNacimiento().getTime());
            if (insertarPersona(
                    objFamilia.getRut(),
                    objFamilia.getNombreCompleto(),
                    fechaNacimiento,
                    objFamilia.getDomicilio(),
                    objFamilia.getCiudad(),
                    objFamilia.getPais(),
                    objFamilia.getCorreo(),
                    objFamilia.getTelefono(),
                    objFamilia.getTipo())) {
                
                String sql = "INSERT INTO CEM.FAMILIA_ANFITRIONA (RUT_PERSONA, "
                        + "CANTIDAD_INTEGRANTES, ESTADO) VALUES (?, ?, ?)";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setInt   (1, objFamilia.getRut());
                    ps.setShort (2, objFamilia.getCantidadIntegrantes());
                    ps.setString(3, objFamilia.getEstado());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    // Controlar excepción.
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
    
    public int modificarFamilia(FamiliaAnfitriona objFamilia) {
        int resultado = 0;
        if (comprobarRutExistente(objFamilia.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objFamilia.getFechaNacimiento().getTime());
            if (modificarPersona(
                    objFamilia.getRut(),
                    objFamilia.getNombreCompleto(),
                    fechaNacimiento,
                    objFamilia.getDomicilio(),
                    objFamilia.getCiudad(),
                    objFamilia.getPais(),
                    objFamilia.getCorreo(),
                    objFamilia.getTelefono(),
                    objFamilia.getTipo())) {
                
                String sql = "UPDATE CEM.FAMILIA_ANFITRIONA "
                        + "SET CANTIDAD_INTEGRANTES = ?, ESTADO = ? "
                        + "WHERE RUT_PERSONA = ?";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setShort (1, objFamilia.getCantidadIntegrantes());
                    ps.setString(2, objFamilia.getEstado());
                    ps.setInt   (3, objFamilia.getRut());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    // Controlar excepción.
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
    
    public ArrayList<FamiliaAnfitriona> listarFamilias() {
        
        ArrayList<FamiliaAnfitriona> listado = new ArrayList<>();
        String sql = "SELECT CANTIDAD_INTEGRANTES, ESTADO, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, "
                + "CORREO, TELEFONO, TIPO FROM CEM.FAMILIA_ANFITRIONA "
                + "INNER JOIN CEM.PERSONA "
                + "ON FAMILIA_ANFITRIONA.RUT_PERSONA = PERSONA.RUT";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                listado.add(new FamiliaAnfitriona(
                        // Datos de familia:
                        rs.getShort(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        null
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
    
    public FamiliaAnfitriona buscarFamilia(int rutPersona) {
        FamiliaAnfitriona familia = null;
        String sql = "SELECT CANTIDAD_INTEGRANTES, ESTADO, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, "
                + "CORREO, TELEFONO, TIPO FROM CEM.FAMILIA_ANFITRIONA "
                + "INNER JOIN CEM.PERSONA "
                + "ON FAMILIA_ANFITRIONA.RUT_PERSONA = PERSONA.RUT"
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rutPersona);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                familia = new FamiliaAnfitriona(
                        // Datos de familia:
                        rs.getShort(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        null
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return familia;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Asignatura ">
    
    public boolean insertarAsignatura(Asignatura objAsignatura) {
        boolean resultado = false;
        String sql = "INSERT INTO CEM.ASIGNATURA (CODIGO, RUT_DOCENTE, "
                + "NOMBRE_ASIGNATURA, DESCRIPCION, CUPOS) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setLong  (1, objAsignatura.getCodigo());
            
            ps.setInt   (2, objAsignatura.getDocente().getRut());
            
            ps.setString(3, objAsignatura.getNombreAsignatura());
            ps.setString(4, objAsignatura.getDescripcion());
            ps.setLong  (5, objAsignatura.getCupos());
            ps.executeLargeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            // Controlar exceptión.
        }
        return resultado;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Docente : Completo ">
    
    public int ingresarDocente(Docente objDocente) {
        
        int resultado = 0;
        if (!comprobarRutExistente(objDocente.getRut())) {
            
            Date fechaNacimiento = new java.sql.Date(
                    objDocente.getFechaNacimiento().getTime());
            if (insertarPersona(
                    objDocente.getRut(),
                    objDocente.getNombreCompleto(),
                    fechaNacimiento,
                    objDocente.getDomicilio(),
                    objDocente.getCiudad(),
                    objDocente.getPais(),
                    objDocente.getCorreo(),
                    objDocente.getTelefono(),
                    objDocente.getTipo())) {
                
                String sql = "INSERT INTO CEM.DOCENTE (RUT_PERSONA, ESTADO, "
                        + "OBSERVACIONES) VALUES (?, ?, ?, ?, ?)";
                
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setLong  (1, objDocente.getRut());
                    ps.setString(2, objDocente.getEstado());
                    ps.setString(3, objDocente.getObservaciones());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    // Controlar excepción.
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
    
    public Docente buscarDocente(int rutPersona) {
        Docente objDocente = null;
        String sql = "SELECT ESTADO, OBSERVACIONES, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, DOMICILIO, CIUDAD, PAIS, CORREO, TELEFONO, "
                + "TIPO FROM CEM.DOCENTE INNER JOIN CEM.PERSONA "
                + "ON DOCENTE.RUT_PERSONA = PERSONA.RUT"
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rutPersona);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                objDocente = new Docente(
                        // Datos de docente:
                        rs.getString(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return objDocente;
    }
    
    public ArrayList<Docente> listarDocentes() {
        ArrayList<Docente> listado = new ArrayList<>();
        String sql = "SELECT ESTADO, OBSERVACIONES, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, DOMICILIO, CIUDAD, PAIS, CORREO, TELEFONO, "
                + "TIPO FROM CEM.DOCENTE INNER JOIN CEM.PERSONA "
                + "ON DOCENTE.RUT_PERSONA = PERSONA.RUT";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                listado.add(new Docente(
                        // Datos de docente:
                        rs.getString(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            // Controlar excepción.
        }
        return listado;
    }
    
    public int modificarDocente(Docente objDocente) {
        
        int resultado = 0;
        if (comprobarRutExistente(objDocente.getRut())) {
            
            Date fechaNacimiento = new java.sql.Date(
                    objDocente.getFechaNacimiento().getTime());
            
            if (modificarPersona(
                    objDocente.getRut(),
                    objDocente.getNombreCompleto(),
                    fechaNacimiento,
                    objDocente.getDomicilio(),
                    objDocente.getCiudad(),
                    objDocente.getPais(),
                    objDocente.getCorreo(),
                    objDocente.getTelefono(),
                    objDocente.getTipo())) {
                
                String sql = "UPDATE CEM.DOCENTE SET ESTADO = ?, "
                        + "OBSERVACIONES = ? WHERE RUT_PERSONA = ?";
                
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setString(1, objDocente.getEstado());
                    ps.setString(2, objDocente.getObservaciones());
                    ps.setInt   (3, objDocente.getRut());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    // Controlar excepción.
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
    
    public boolean ingresarAntecedente(Antecedente objAntecedente,
            int rutPersona) {
        
        boolean resultado = false;
        
        return resultado;
    }
    
}
