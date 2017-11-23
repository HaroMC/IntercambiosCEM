package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Alumno;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Consultas extends HttpServlet {
    
    private DaoEntidades dao;

    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Alumno> listadoAlumnos = dao.listarAlumnos();
        
        request.getSession().setAttribute("listadoAlumnos", listadoAlumnos);
                
        request.getRequestDispatcher("listarAlumnos.jsp")
                .forward(request, response);
        
    }
    
}
