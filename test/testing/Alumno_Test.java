package testing;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Alumno;
import cem.modelo.entidad.Persona;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno_Test {

    public static void main(String[] args) {

        DaoEntidades dao = new DaoEntidades();
        Alumno alumno;
        
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
        Logger.getLogger(Programa_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = format.parse("1964-06-12");
            Date fechaMatricula = format.parse("2000-01-01");

            alumno = new Alumno(
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
            
            switch (dao.insertarAlumno(alumno)) {
                
                case -2:
                    System.out.println("\nEl rut ingresado ya existe en la "
                            + "base de datos.\n");
                    break;
                    
                case -1:
                    System.out.println("\nError al insertar los datos de la "
                            + "persona.\n");
                    break;
                    
                case 0:
                    System.out.println("\nError al insertar los datos del "
                            + "alumno.\n");
                    break;
                    
                case 1:
                    System.out.println("\nAlumno insertado correctamente.\n");
            }
        }
        catch (ParseException pe) {
            Logger.getLogger(Programa_Test.class.getName())
                    .log(Level.SEVERE, null, pe);
        }

        /*java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);*/
    }

}
