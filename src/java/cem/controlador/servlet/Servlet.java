package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Alumno;
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // El formate de fechas se ocupa en muchas operaciones, por lo que bien
        // puede ser declarado desde aquí y reutilizar la variable.
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String accion = request.getParameter("accion");

        switch (accion) {
            
            //<editor-fold defaultstate="collapsed" desc=" Agregar programa ">
            case "agregarPrograma":
                try {
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
                        // Si el método, luego de realizar la inserción,
                        // retorna true, editamos el mensaje en el formulario
                        // de agregar programa.
                        request.setAttribute("mensaje", "Programa agregado "
                                + "correctamente.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                    else {
                        // Si el método retorna false, informamos que el
                        // problema se encuentra en el DAO.
                        request.setAttribute("mensaje", "Se ha producido un "
                                + "error al registrar.");
                        request.getRequestDispatcher("agregarPrograma.jsp")
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(Servlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                break;
                //</editor-fold>
            
                
                // Falta generar el formulario para ingresar un alumno.
                // Puede ser en el grid final o en un formulario temporal creado
                // para el caso.
                
            //<editor-fold defaultstate="collapsed" desc=" Agregar alumno ">
            case "agregarAlumno":
                try {
                    Alumno alumno = new Alumno(
                            Long.parseLong(
                                    request.getParameter("numeroMatricula")),
                            format.parse(
                                    request.getParameter("fechaMatricula")),
                            Integer.parseInt(
                                    request.getParameter("rutPersona")),
                            request.getParameter("nombreCompleto"),
                            format.parse(
                                    request.getParameter("fechaNacimiento")),
                            request.getParameter("domicilio"),
                            request.getParameter("ciudad"),
                            request.getParameter("pais"),
                            request.getParameter("correo"),
                            request.getParameter("telefono"),
                            "Alumno"
                    );
                    // El método de insertar alumno retorna 4 niveles de
                    // alertas diferentes.
                    switch (dao.insertarAlumno(alumno)) {
                        case -2:
                            request.setAttribute("mensaje", "El rut ingresado "
                                    + "ya existe en la base de datos.");
                            request.getRequestDispatcher("agregarAlumno.jsp")
                                    .forward(request, response);
                            break;
                            
                        case -1:
                            request.setAttribute("mensaje", "Error al insertar "
                                    + "los datos de la persona.");
                            request.getRequestDispatcher("agregarAlumno.jsp")
                                    .forward(request, response);
                            break;
                            
                        case 0:
                            request.setAttribute("mensaje", "Error al insertar "
                                    + "los datos del alumno.");
                            request.getRequestDispatcher("agregarAlumno.jsp")
                                    .forward(request, response);
                            break;
                            
                        case 1:
                            request.setAttribute("mensaje", "Alumno insertado "
                                    + "correctamente.");
                            request.getRequestDispatcher("agregarAlumno.jsp")
                                    .forward(request, response);
                    }
                }
                catch (ParseException se) {
                    Logger.getLogger(Servlet.class.getName())
                            .log(Level.SEVERE, null, se);
                }
                break;
                //</editor-fold>
                
            case "NUEVO_CASO":
                break;
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    }
}
