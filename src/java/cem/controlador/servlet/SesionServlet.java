package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*borra este mensaje harold*/

public class SesionServlet extends HttpServlet {
    
    private DaoEntidades dao;
    private HttpSession sesion;
    
    @Override
    public void init() {
        dao = new DaoEntidades();
        sesion = null;
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("login.jsp").include(request, response);
        
        Usuario objUsuario = dao.buscarUsuario(
                request.getParameter("nombreUsuario"),
                request.getParameter("contrasena")
        );

        if (objUsuario != null) {
            sesion = request.getSession(true);
            sesion.setAttribute("usuarioActual", objUsuario);
            switch (objUsuario.getPerfil()) {
                case "Administrador":
                    response.sendRedirect("index.jsp");
                    break;
                case "CEL":
                    response.sendRedirect("menuCEL.jsp");
                    break;
                case "Alumno":
                    response.sendRedirect("index.jsp");
                    break;
                case "Familia":
                    response.sendRedirect("index.jsp");
                    break;
                default:
                    response.sendRedirect("no-autorizado.html");
            }
        }
        else {
            request.setAttribute("mensaje", "Sus credenciales no son válidas.");
            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
    
}
