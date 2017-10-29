/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        //ACCIONES DEL SERVLET SEGUN EL FORMULARIO

        switch (accion) {
            case "agregarPrograma":
                //<editor-fold defaultstate="collapsed" desc="Proceso para agregar un programa ">

                //PROCESO PARA INSERTAR UN PROGRAMA
                //Instanciamos el DAO que contience el metodo de agregar un programa
                DaoEntidades DAO = new DaoEntidades();

                //Instanciamos un programa
                Programa p = new Programa();

                try {
                    //Asignamos los valores recibidos a los atributos de la instancia
                    //(Excepto los atributos que no requieren ser enviados por el usuario)
                    //Asignamos el codigo en BigDecimal (llamamos al metodo que retorna el ultimo numero)
                    p.setCodigo(DAO.ultimoCodigoPrograma() + 1);
                } catch (SQLException ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Agregamos el nombre
                p.setNombre(request.getParameter("nombrePrograma"));
                //FECHA INICIO (guardamos la fecha en un string, generamos un formato 
                //simpledateformat, una fecha, y la fecha la igualamos al string parseado a 
                //Simpledateformat que habiamos definido.)
                String tempDate = request.getParameter("fecha");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = new Date();
                //realizamos el parseo dentro de un trycatch ya que SimpleDateFormat lo requiere así
                try {
                    fecha = sdf.parse(tempDate);
                } catch (ParseException ex) {
                }
                try {
                    fecha = sdf.parse(tempDate);
                } catch (ParseException ex) {
                }
                //FECHA TERMINO (lo mismo de lo anterior)
                String tempDate2 = request.getParameter("fecha2");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha2 = new Date();
                try {
                    fecha2 = sdf2.parse(tempDate2);
                } catch (ParseException ex) {
                }
                p.setValor(Integer.parseInt(request.getParameter("valor")));
                p.setEstado("Sin CEL asignado");
                 {
                    try {
                        //Llamamos a la funcion de agregar un programa, la cual requiere de un Programa (p)
                        if (DAO.insertarPrograma(p)) {
                            //Si el metodo, luego de realizar la insercion, retorna true, editamos el mensaje
                            //en el formulario de agregar programa.
                            request.setAttribute("mensaje", "Programa agregado correctamente "
                                    + "al sistema");
                            request.getRequestDispatcher("agregarPrograma.jsp").
                                    forward(request, response);
                        } else {
                            //Si el metodo retorna false, informamos que el problema se encuentra en el DAO
                            request.setAttribute("mensaje", "Error al llegar al DAO");
                            request.getRequestDispatcher("agregarPrograma.jsp").
                                    forward(request, response);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //</editor-fold>
                break;

        }

    }

}
