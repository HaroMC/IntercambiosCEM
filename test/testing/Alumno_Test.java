package testing;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Alumno;
import cem.modelo.entidad.Persona;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno_Test {

    public static void main(String[] args) {

        DaoEntidades dao = new DaoEntidades();

        //<editor-fold defaultstate="collapsed" desc=" Prueba de consulta completa : Correcta ">
        /*
        ArrayList<Alumno> listado = dao.listarAlumnos();
        if (listado != null) {
            listado.forEach((a) -> {
                System.out.println(a.toString());
            });
        }
        else {
            System.out.println("\nNo se encontraron alumnos registrados.\n");
        }
        */
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de inserción : Completa ">
        /*
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
        } catch (ParseException pe) {
            Logger.getLogger(Programa_Test.class.getName())
                    .log(Level.SEVERE, null, pe);
        }
        */
        //</editor-fold>

    }

}
