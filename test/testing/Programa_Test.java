package testing;

import cem.controlador.dao.DaoEntidades;
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

public class Programa_Test {

    public static void main(String[] args) {

        DaoEntidades dao = new DaoEntidades();
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de consulta individual : Pendiente ">
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de consulta completa : Correcta ">
        /*
        ArrayList<Programa> listado;
        listado = dao.listarProgramas();
        if (listado != null) {
            listado.forEach((programa) -> {
                System.out.println("Código encontrado   : "
                        + programa.getCodigo());
                System.out.println("Nombre del programa : "
                        + programa.getNombre());
                System.out.println("Estado              : "
                        + programa.getEstado());
                System.out.println("");
            });
        }
        */
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de modificación : Pendiente ">
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de inserción : Correcta ">
        /*
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
            Logger.getLogger(Programa_Test.class.getName()).log(Level.SEVERE, null, e);
        }
        */
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Prueba de eliminación : Correcta ">
        /*
        long codigo = 5;
        
        while (codigo <= 15) {
            if (dao.eliminarPrograma(codigo)) {
                System.out.println("\nPrograma " + codigo + " eliminado "
                        + "correctamente.");
            }
            else {
                System.out.println("No se ha logrado eliminar el programa "
                        + codigo);
            }
            codigo ++;
        }
        */
        //</editor-fold>
    }
}
