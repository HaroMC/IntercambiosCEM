
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true"
         import="cem.modelo.entidad.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Bienvenido </title>
    </head>
    <body>
        <h1>
            Sistema de intercambios estudiantiles <br />
            Centro de Estudios Montreal
        </h1>
        <form action="ingresar" method="post">
            <table>
                <tr>
                    <td> Nombre de usuario </td>
                </tr>
                <tr>
                    <td> <input type="text" name="nombreUsuario"
                                required="true" /> </td>
                </tr>
                <tr>
                    <td> Contraseña </td>
                </tr>
                <tr>
                    <td> <input type="password" name="contrasena"
                                required="true" /> </td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Ingresar" /> </td>
                </tr>
            </table>
            <br />
            <label> ${mensaje} </label>
        </form>
    </body>
</html>
