package cem.service.servicioweb;

import cem.modelo.entidad.Usuario;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "consultarAlumnos")
public class consultarAlumnos {

    private int rut;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String domicilio;
    private String ciudad;
    private String pais;
    private String correo;
    private String telefono;
    private String tipo;
    private Usuario usuario;
    
    
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
