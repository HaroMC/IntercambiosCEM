package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Alumno;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CemAlumnoServlet extends HttpServlet {

    private DaoEntidades dao;
    
    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            if (accion.compareToIgnoreCase("eliminar") == 0) {
                
            }
        }
        else {
            
            // Definir que tipo de usuario es para redfireccionarlo a la página
            // que corresponda.
            
            String perfil = 
                    ((Usuario) request.getSession()
                    .getAttribute("usuarioActual")).getPerfil();
            
            ArrayList<Alumno> listadoAlumnos = dao.listarAlumnos();
            
            //Alumno alumno = new Alumno();
            //String usuario = alumno.getUsuario().getNombre();
            
            request.getSession().setAttribute("listadoAlumnos", listadoAlumnos);
            
            switch (perfil) {
                
                case "Administrador":
                    request.getRequestDispatcher("CEM_administracion_alumnos.jsp")
                            .forward(request, response);
                break;
                
                case "CEL":
                    request.getRequestDispatcher("NO-SE-QUE-PAGINA.jsp")
                            .forward(request, response);
                    break;
                    
                case "Alumno":
                    request.getRequestDispatcher("Alumno_postulaciones.jsp")
                            .forward(request, response);
                    break;
                    
                case "Familia":
                    request.getRequestDispatcher("NO-SE-QUE-PAGINA.jsp")
                            .forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            
            case "agregar":
                break;
                
            case "modificar":
                break;
        }
    }

}
