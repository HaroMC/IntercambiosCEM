package test;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserTest {
    
    public static void main(String[] args) {
        
        DaoEntidades dao = new DaoEntidades();
        Usuario objUsuario;
        
        ArrayList<Alumno> alumnos = dao.listarAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
        
        
        
        /*DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar cal = Calendar.getInstance();
        Date fechaRegistro;
        
        try {
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH));
            String day_of_month = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            
            fechaRegistro = formato.parse(year + "-" + month + "-" + day_of_month);
            
            objUsuario = new Usuario(
                    dao.ultimoCodigoIncremental("USUARIO") + 1,
                    "maria.lopez",
                    "maria123",
                    fechaRegistro,
                    "25365874-k",
                    "Familia"
            );
            if (dao.registrarUsuario(objUsuario, "25365874-k", "maria123")) {
                System.out.println("Registro correcto.");
            }
            else {
                System.out.println("No se logró el registro.");
            }
        }
        catch (ParseException ex) {
            Logger.getLogger(UserTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        /*String rut = "95684251-k";
        boolean resultado = comprobarRutExistente(rut);
        //if (!resultado.isEmpty()) {
        if (resultado == true) {
            //System.out.println("\nEl rut " + rut + " pertenece a " + resultado + ".\n");
            System.out.println("\nEl rut " + rut + " SI existe en la base de datos.\n");
        }
        else {
            System.out.println("\nEl rut " + rut + " NO existe en la base de datos.\n");
        }*/
        /*
        ArrayList<Programa> listaProgramasParaCel = dao.listarProgramasParaPostularCel();
        
        for (Programa programa : listaProgramasParaCel) {
            System.out.println("Nombre: " + programa.getNombre() + "\nEstado: " + programa.getEstado());
        }*/
    }
    
}
