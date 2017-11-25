package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import cem.modelo.entidad.Usuario;
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

/**
 * Servlet encargado de mediar entre las acciones en pantalla con el acceso a
 * datos desde el DAO de los objetos <code>Programa</code>.
 * @author Harold Maureira.
 * @version 1.0
 */
public class ProgramaServlet extends HttpServlet {
    
    /**
     * Instancia del DAO a cargo de controlar las consultas de los objetos
     * <code>Programa</code> a la base de datos.
     */
    private DaoEntidades dao;
    
    /**
     * Método que inicializa la instancia del DAO al momento de la carga de la
     * página.
     */
    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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
            
            // Definir que tipo de usuario es para redfireccionarlo a la página
            // que corresponda.
            
            String perfil = 
                    ((Usuario) request.getSession()
                    .getAttribute("usuarioActual")).getPerfil();
            
            ArrayList<Programa> listadoProgramas = dao.listarProgramas();
            
            request.getSession().setAttribute(
                    "listadoProgramas", listadoProgramas);
            
            switch (perfil) {
                
                case "Administrador":
                    request.getRequestDispatcher("CEM_ver_programas.jsp")
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
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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
