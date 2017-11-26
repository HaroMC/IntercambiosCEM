package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.FamiliaAnfitriona;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroServlet extends HttpServlet {

    private DaoEntidades dao;
    
    @Override
    public void init() throws ServletException {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException { }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("type");
        String perfil;
        String estado;
        
        if (accion != null) {
            if (accion.compareToIgnoreCase("familia") == 0) {
                perfil = "Familia" ;
                estado = "Aprobación pendiente";
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                
                try {
                    /**
                     * Se instancia una <code>FamiliaAnfitriona</code>
                     * capturando los ingresos desde el formulario de registro.
                     */
                    FamiliaAnfitriona objFamilia = new FamiliaAnfitriona(
                            Short.parseShort(
                                    request.getParameter("cantidadIntegrantes")
                            ),
                            estado,
                            request.getParameter("run"),
                            request.getParameter("nombreJefeFamilia") + " " +
                                    request.getParameter("apellidoJefeFamilia"),
                            formato.parse(
                                    request.getParameter("fechaNacimiento")
                            ),
                            request.getParameter("domicilio"),
                            request.getParameter("ciudad"),
                            request.getParameter("pais"),
                            request.getParameter("correo"),
                            request.getParameter("telefono"),
                            perfil
                    );
                    
                    /**
                     * Se consulta el resultado del registro en la base de
                     * datos.
                     */
                    if (dao.insertarFamilia(objFamilia) != 1) {
                        request.setAttribute("mensaje", "Error de registro.");
                        request.getRequestDispatcher("registro.jsp")
                                .forward(request, response);
                    }
                    
                    /**
                     * Si el registro funcionó correctamente, se procede a
                     * crear el <code>Usuario</code> correspondiente.
                     */

                    // Método para obtener la fecha en el momento del registro.
                    Calendar cal = Calendar.getInstance();
                    Date fechaRegistro = formato.parse(
                            Integer.toString(cal.get(Calendar.YEAR))+ "-" +
                            Integer.toString(cal.get(Calendar.MONTH)) + "-" +
                            Integer.toString(cal.get(Calendar.DAY_OF_MONTH))
                    );
                    
                    Usuario objUsuario = new Usuario(
                            dao.ultimoCodigoIncremental("USUARIO") + 1,
                            request.getParameter("nombreUsuario"),
                            request.getParameter("clave1"),
                            fechaRegistro,
                            request.getParameter("run"),
                            perfil
                    );
                    
                    if (dao.registrarUsuario(objUsuario,
                            request.getParameter("run"),
                            request.getParameter("clave1"))) {
                        
                        request.setAttribute("mensaje", "Se ha registrado "
                                + "correctamente.\n Ahora puede iniciar "
                                + "sesión.");
                        request.getRequestDispatcher("login.jsp")
                                .forward(request, response);
                    }
                    else {
                        request.setAttribute("mensaje", "Error de registro.");
                        request.getRequestDispatcher("registro.jsp")
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(RegistroServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            else {
                if (accion.compareToIgnoreCase("alumno") == 0) {
                    /**
                     * Desarrollar el registro de la CUENTA DE USUARIO del
                     * alumno en la base de datos.
                     */
                }
            }
        }
    }
    
}
