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

public class ProgramaServlet extends HttpServlet {

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
                Long codigo = Long.parseLong(request.getParameter("codigo"));
                request.getParameter("codigo");
                if (dao.eliminarPrograma(codigo)) {
                    
                }
            }
        }
        else {
            ArrayList<Programa> listadoProgramas = dao.listarProgramas();
            request.getSession().setAttribute(
                    "listadoProgramas", listadoProgramas);
            request.getRequestDispatcher("Alumno_postulaciones.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
                
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String accion = request.getParameter("accion");
        String mensaje;
        
        switch (accion) {
            
            case "agregar":
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
                        mensaje = "Programa agregado.";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                    else {
                        mensaje = "Error de registro.";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher(
                                "agregarPrograma.jsp?mensaje=" + mensaje)
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(EntidadServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("      ");
                break;
                
            case "modificar":
                break;
        }
        
    }
    
}
