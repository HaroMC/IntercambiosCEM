package testing;

import cem.controlador.dao.DaoEntidades;
import cem.controlador.dao.DaoEntidadesPA;
import cem.modelo.entidad.Alumno;
import cem.modelo.entidad.Programa;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        DaoEntidades dao = new DaoEntidades();
        
        //<editor-fold defaultstate="collapsed" desc=" Trasteando, no borrar ">

        /*
        try {
        ArrayList<Alumno> alumnos = dao.listarAlumnos();
        for (Alumno alumno : alumnos) {
        System.out.println("Número matrícula : " + alumno.getNumeroMatricula());
        System.out.println("Fecha matrícula  : " + alumno.getFechaMatricula());
        System.out.println("");
        }
        }
        catch (SQLException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        */

        /*try {
        DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = formateador.parse("1964-06-12");
        Date fechaMatricula = formateador.parse("2000-01-01");

        Alumno alumno = new Alumno(
        3213545,
        fechaMatricula,
        154789654,
        "Juan Lira Lira",
        fechaNacimiento,
        "Calle 3654",
        "Santiago",
        "Chile",
        "juan.lira@correo.com",
        "9-2514-3652",
        "Alumno"
        );

        //if (dao.insertarAlumno(alumno)) {
        if (dao.insertarPersona(
        154789654,
        "Juan Lira Lira",
        (java.sql.Date) fechaNacimiento,
        "Calle 3654",
        "Santiago",
        "Chile",
        "juan.lira@correo.com",
        "9-2514-3652",
        "Alumno")) {
        System.out.println("Persona insertada correctamente");
        }
        else {
        System.out.println("No se logró insertar la persona.");
        }
        }
        catch (ParseException | SQLException e) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }*/

        /*java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);*/
        //</editor-fold>
        
        try {
            long codigo = dao.ultimoCodigoPrograma();
            System.out.println("Último código = " + codigo);
            
            DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            
            Date fechaIn = formateador.parse("1964-06-12");
            Date fechaTe = formateador.parse("2000-01-01");
            
            Long nuevoCodigo = codigo + 1;
            
            Programa programa = new Programa(nuevoCodigo, "ProgramaX", fechaIn,
                    fechaTe, 1000000, "No publicado");
            
            System.out.println("Intentando inserción:\n\n"
                    + "Código          : " + nuevoCodigo + "\n"
                    + "Nombre programa : ProgramaX\n"
                    + "Fecha inicio    : " + fechaIn + "\n"
                    + "Fecha término   : " + fechaTe + "\n"
                    + "Valor           : 1000000\n"
                    + "Estado          : No publicado\n"
            );
            
            if(dao.insertarPrograma(programa)) {
                System.out.println("Programa insertado correctamente.");
            }
            else {
                System.out.println("Programa no insertado.");
            }
        }
        catch (SQLException | ParseException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}