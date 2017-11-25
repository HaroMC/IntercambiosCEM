package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private DaoEntidades dao;
    private HttpSession sesion;

    @Override
    public void init() {
        dao = new DaoEntidades();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp")
                .include(request, response);

        Usuario usuarioActual = dao.buscarUsuario(
                request.getParameter("nombreUsuario"),
                request.getParameter("contrasena")
        );

        if (usuarioActual != null) {
            
            sesion = request.getSession(true);
            
            sesion.setAttribute("usuarioActual", usuarioActual);
            
            redireccionarPerfil(request, response, usuarioActual.getPerfil());
        }
        else {
            String mensaje = "Sus credenciales no son válidas.";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        sesion = request.getSession();
        
        if ((Usuario) sesion.getAttribute("usuarioAcual") != null) {
            String perfil = ((Usuario) sesion
                    .getAttribute("usuarioActual"))
                    .getPerfil();
            redireccionarPerfil(request, response, perfil);
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }

    private void redireccionarPerfil(HttpServletRequest request,
            HttpServletResponse response, String perfil)
            throws ServletException, IOException {
        
        switch (perfil) {
            case "Administrador":
                response.sendRedirect("menuCEM.jsp");
                break;
                
            case "CEL":
                response.sendRedirect("menuCEL.jsp");
                break;
                
            case "Alumno":
                response.sendRedirect("menuAlumno.jsp");
                break;
                
            case "Familia":
                response.sendRedirect("menuFamilia.jsp");
                break;
                
            default:
                response.sendRedirect("no-autorizado.html");
        }
    }

}
