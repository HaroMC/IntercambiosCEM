<%-- 
    Document   : CEM_postulasiones_CEL
    Created on : 30-10-2017, 9:30:09
    Author     : Bugueño
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="menuCEM.jsp">Home</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracion de Usuarios
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="CEM_administracion_alumnos.jsp">Alumnos</a></li>
                            <li><a href="CEM_administracion_familia.jsp">Familia</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracion de programas
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="CEM_administrar_programas.jsp">Ver listado de Programas</a></li>
                            <li><a href="CEM_agregarPrograma.jsp">Agregar Programas</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Consultar Postulaciones
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="CEM_postulasiones_CEL.jsp">CEL's</a></li>
                            <li><a href="CEM_postulasiones_alumnos.jsp">Alumnos</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>
        <h1>Postulasiones CEL's</h1>
        <div class="container">
            <h2>CEL's</h2>      
            <p>Filtra tu busqueda aqui:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre del programa al que postula</th>
                        <th>Postulantes</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td>Desarrollo en MEAN</td>
                        <td>Universidad de Cataluña</td>
                        <th>Aceptado</th>
                    </tr>
                    <tr>
                        <td>Gestion de Personas</td>
                        <td>Universidad de Colombia</td>
                        <th>Rechazado</th>
                    </tr>
                    <tr>
                        <td>Desarrollo en MEAN</td>
                        <td>Universidad de Toronto</td>
                        <th>Aceptado</th>
                    </tr>   
                </tbody>
            </table>
            <button type="button" class="btn btn-primary">
                Aceptar
            </button>
            <button type="button" class="btn btn-primary">
                Rechazar
            </button>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
    </script>
</html>
