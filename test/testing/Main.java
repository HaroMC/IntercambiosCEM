package testing;

import cem.controlador.dao.DaoEntidades;
import cem.controlador.dao.DaoEntidadesPA;
import cem.modelo.entidad.Alumno;
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
            
            if (dao.insertarAlumno(alumno)) {
            System.out.println("Persona insertada correctamente");
            }
            else {
            System.out.println("No se logró insertar la persona.");
            }
            }
            catch (ParseException | SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }*/
    }
}
