package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet {
    
    // Como el dao es una clase que se requiere para todo el servlet, es
    // más conveniente declararla como un atributo de la clase...
    private DaoEntidades dao;
    
    @Override
    public void init() {
        // ... E instanciarlo cada vez que se llame al servlet desde el
        // método de inicialización.
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        switch (accion) {
            
            case "agregarPrograma":
                try {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    // Instanciamos un programa utilizando el constructor con
                    // parámetros.
                    Programa p = new Programa(
                            // Código:
                            dao.ultimoCodigoPrograma() + 1,
                            // Nombre del programa:
                            request.getParameter("nombrePrograma"),
                            // Fecha de inicio:
                            format.parse(request.getParameter("fechaInicio")),
                            // Fecha de término:
                            format.parse(request.getParameter("fechaTermino")),
                            // Valor del programa:
                            Integer.parseInt(request.getParameter("valor")),
                            // Estado inicial:
                            "Sin CEL asignado"
                    );
                    // Llamamos a la funcion de agregar un programa, la cual
                    // requiere de un Programa (p).
                    if (dao.insertarPrograma(p)) {
                        // Si el metodo, luego de realizar la insercion, retorna
                        // true, editamos el mensaje en el formulario de agregar
                        // programa.
                        request.setAttribute("mensaje", "Programa agregado "
                                + "correctamente.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                    else {
                        // Si el metodo retorna false, informamos que el
                        // problema se encuentra en el DAO.
                        request.setAttribute("mensaje", "Se ha producido un "
                                + "error al registrar.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                }
                catch (SQLException | ParseException ex) {
                    Logger.getLogger(Servlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                break;
                
            case "NUEVO_CASO":
                break;
        }
    }
}
