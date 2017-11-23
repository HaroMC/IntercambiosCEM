<%-- 
    Document   : menuAlumno
    Created on : 20-11-2017, 23:11:45
    Author     : Bugueño
--%>

<%  if (session.getAttribute("usuarioActual") == null) {
       response.sendRedirect("no-autorizado.html");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"> WebSiteName </a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="Alumno_perfil.jsp"> Perfil </a></li>                    
                        <li><a href="programas.htm?accion=listar"> Postulaciones </a></li>
                    </ul>                  
                </div>
            </nav>
    </body>
</html>
