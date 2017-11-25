package test;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.*;
import java.util.ArrayList;

public class UserTest {
    
    public static void main(String[] args) {
        
        DaoEntidades dao = new DaoEntidades();
        Usuario objUsuario;
        /*
        String nombreUsuario = "j.perez";
        String contrasena = "juan123";
        
        objUsuario = dao.buscarUsuario(nombreUsuario, contrasena);
        
        if (objUsuario != null) {
            System.out.println("\nUsuario : " + objUsuario.getNombre() + "\n");
        }
        else {
            System.out.println("\nNo se encuentra el usuario.\n");
        }*/
        
        ArrayList<Alumno> listaAlumno = dao.listarAlumnos();
        
        listaAlumno.forEach((alumno) -> {
            System.out.println("Alumno : " + alumno.getNombreCompleto());
        });
        /*
        ArrayList<Programa> listado = dao.listarProgramas();
        for (Programa programa : listado) {
        System.out.println("Programa: " + programa.getNombre());
        }*/ /*
        ArrayList<Usuario> listadoUsuario = dao.listarUsuarios();
        for (Usuario usuario : listadoUsuario) {
        System.out.println("Usuario : " + usuario.getNombre());
        }*/
        
        
    }
}
