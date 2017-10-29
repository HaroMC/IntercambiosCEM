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
        <title>Bienvenido</title>
    </head>
    <body>
        <h1>
            Ingreso al sistema de intercambio de estudiantes <br>
            Centro de Estudios Montreal
        </h1>
        <form action="" method="POST">
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
                    <tr>
                        <td> <input type="submit" name="ingresar"/> </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
