<%-- 
    Document   : login
    Created on : 28-oct-2017, 19:08:27
    Author     : HaroMC
--%>

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
        <h1>
            Ingreso al sistema de intercambio de estudiantes <br>
            Centro de Estudios Montreal
        </h1>
        <form class="form-signin" action="Servlet" method="POST">
            <h2 class="form-signin-heading"> Porfaor ingrese al sistema</h2>
            <table border="0" cellpadding="2">
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> Nombre de usuario </td>
                    </tr>
                    <tr>
                        <td> <input type="text" name="nombreUsuario"/> </td>
                    </tr>
                    <tr>
                        <td> Contraseña </td>
                    </tr>
                    <tr>
                        <td> <input type="password" name="contrasena"/>  </td>
                    </tr>
                    
                </tbody>             
            </table>
            <input type="text" name="accion" value="login" hidden="true" />
            <button class="btn-lg" type="submit">ingresar</button>
        </form>
    </body>
</html>
