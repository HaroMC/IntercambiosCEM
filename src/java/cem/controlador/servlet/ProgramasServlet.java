package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProgramasServlet extends HttpServlet {

    private DaoEntidades dao;

    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Programa> listadoProgramas = dao.listarProgramas();
        request.getSession().setAttribute("listadoProgramas", listadoProgramas);
        request.getRequestDispatcher("Alumno_postulaciones.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "agregarPrograma":
                try {
                    Programa objPrograma = new Programa(
                            dao.ultimoCodigoIncremental("PROGRAMA") + 1,
                            request.getParameter("nombrePrograma"),
                            format.parse(request.getParameter("fechaInicio")),
                            format.parse(request.getParameter("fechaTermino")),
                            Integer.parseInt(request.getParameter("valor")),
                            "Sin CEL asignado"
                    );
                    if (dao.insertarPrograma(objPrograma)) {
                        request.setAttribute("mensaje", "Programa agregado "
                                + "correctamente.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                    else {
                        request.setAttribute("mensaje", "Se ha producido un "
                                + "error al registrar.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(EntidadServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                break;
        }
        
    }
    
}
