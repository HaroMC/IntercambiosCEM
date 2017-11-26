package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CelProgramasServlet extends HttpServlet {

    private DaoEntidades dao;
    
    @Override
    public void init() throws ServletException {
        dao = new DaoEntidades();
    }

    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            if (accion.compareToIgnoreCase("eliminar") == 0) {
                long codigo = Long.parseLong(request.getParameter("codigo"));
                if (dao.eliminarPrograma(codigo)) {
                    
                }
            }
        }
        else {
            cargarLista(request);
            request.getRequestDispatcher("CEL_postulaciones.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    }
        
    private void cargarLista(HttpServletRequest request)
            throws ServletException, IOException {
        
        ArrayList<Programa> programasDisponiblesCel = dao.listarProgramas();
        request.getSession().setAttribute(
                "programasDisponiblesCel", programasDisponiblesCel);
    }
    
}
