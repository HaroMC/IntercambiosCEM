<%-- 
    Document   : paginaPrueba
    Created on : 25-11-2017, 3:08:51
    Author     : Bugueño
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <script>
            $(document).on('click', '.borrar', function (event) {
                event.preventDefault();
                $(this).closest('tr').remove();
            });
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <td>Columna 1.1</td>
                <td>Columna 1.2</td>
                <td>Columna 1.3</td>
                <td>Columna 1.4</td>
                <td>Columna 1.5</td>
                <td>Columna 1.6</td>
                <td><input type="button" class="borrar" value="Eliminar" /></td>
            </tr>
        </table>
    </body>
</html>
