<%-- 
    Document   : menuCEL
    Created on : 16-10-2017, 02:27:06 AM
    Author     : David
--%>

<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" 
         session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%  if (session.getAttribute("usuarioActual") == null) {
       response.sendRedirect("no-autorizado.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEL Home</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="CEL_home.jsp">Home</a></li>
                    <li><a href="CEL_calificaciones.jsp">Calificaciones</a></li>
                    <li><a href="CEL_postulaciones.jsp">Postulaciones</a></li>
                </ul>
                <!-- ------------------------------------------------------- -->
                <label class="nav navbar-nav navbar-right" style="color: white">
                    Bienvenido, <%= ((Usuario)(session
                            .getAttribute("usuarioActual"))).getNombre() %>
                    <br />
                    <form action="salir" method="get">
                        <input type="submit" value="Cerrar sesión" />
                    </form>
                </label>
                <!-- ------------------------------------------------------- -->
            </div>
        </nav>
        
    </body>
</html>
