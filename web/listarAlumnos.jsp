<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%  if (session.getAttribute("usuarioActual") == null) {
       response.sendRedirect("no-autorizado.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Listado de alumnos </title>
    </head>
    <body>
        
        <form action="Consultas" method="post">
            <table>
                <h1> Listado de alumnos </h1>
                
                <c:forEach var="a" items="${listadoAlumnos}" >
                <tr>
                    <td> <c:out value="${a.nombreCompleto}" /> </td>
                    <td> <c:out value="${a.rut}" /> </td>
                </tr>
                </c:forEach>
                
            </table>
            <input type="submit" value="Recargar" />
        </form>
        
    </body>
</html>
