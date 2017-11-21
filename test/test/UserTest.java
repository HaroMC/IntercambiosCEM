package test;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.Alumno;
import cem.modelo.entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTest {
    
    public static void main(String[] args) {
        
        DaoEntidades dao = new DaoEntidades();
        Usuario objUsuario;
        
        String nombreUsuario = "j.perez";
        String contrasena = "juan123";
        
        objUsuario = buscarUsuario(nombreUsuario, contrasena);
        
        if (objUsuario != null) {
            System.out.println("\nUsuario : " + objUsuario.getNombre() + "\n");
        }
        else {
            System.out.println("\nNo se encuentra el usuario.\n");
        }
        /*
        ArrayList<Alumno> listaAlumno = dao.listarAlumnos();
        
        for (Alumno alumno : listaAlumno) {
            System.out.println("Alumno : " + alumno.getNombreCompleto());
        }*/
    }
    
    public static Usuario buscarUsuario(String nombreUsuario, String contrasena) {
        Connection c;
        PreparedStatement ps;
        ResultSet rs;
        Usuario objUsuario = null;
        String sql = "SELECT CODIGO, FECHA_REGISTRO, RUT_PERSONA, PERFIL FROM CEM.USUARIO WHERE NOMBRE = ? AND CONTRASENA = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            
            ps.setString(1, "j.perez");
            ps.setString(2, "juan123");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                objUsuario = new Usuario(
                        rs.getLong(1),
                        nombreUsuario,
                        rs.getDate(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
            }
            
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            
        }
        return objUsuario;
    }
}
