
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"> WebSiteName </a>
                </div>
                <ul class="nav navbar-nav">
                    <li> <a href="menuCEM.jsp"> Home </a> </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administración de Usuarios
                            <span class="caret"> </span> </a>
                        <ul class="dropdown-menu">
                            <li> <a href="CEM_administracion_alumnos.jsp"> Alumnos </a> </li>
                            <li> <a href="CEM_administracion_familia.jsp"> Familia </a> </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Administración de programas
                            <span class="caret"> </span> </a>
                        <ul class="dropdown-menu">
                            <li> <a href="CEM_administrar_programas.jsp"> Ver listado de Programas </a> </li>
                            <li> <a href="CEM_agregarPrograma.jsp"> Agregar Programas </a> </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Consultar Postulaciones
                            <span class="caret"> </span> </a>
                        <ul class="dropdown-menu">
                            <li> <a href="CEM_postulasiones_CEL.jsp"> CEL's </a> </li>
                            <li> <a href="CEM_postulasiones_alumnos.jsp"> Alumnos </a> </li>
                        </ul>
                    </li>
                </ul>
                                
                <!-- ------------------------------------------------------------------------------------------------------- -->
                <label class="nav navbar-nav navbar-right" style="color: white">
                    Bienvenido, <%= ((Usuario)(session.getAttribute("usuarioActual"))).getNombre() %>
                    <br />
                    <form action="SesionServlet" method="get">
                        <input type="submit" value="Cerrar sesión" />
                    </form>
                </label>
                <!-- ------------------------------------------------------------------------------------------------------- -->
                
                <!--
                <ul class="nav navbar-nav navbar-right">
                    <li> <a href="#"> <span class="glyphicon glyphicon-user"> </span> Sign Up </a> </li>
                    <li> <a href="#"> <span class="glyphicon glyphicon-log-in"> </span> Login </a> </li>
                </ul>
                -->
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"> </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
                integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
                crossorigin="anonymous"> </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
                integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
                crossorigin="anonymous"> </script>
    </body>
</html>
