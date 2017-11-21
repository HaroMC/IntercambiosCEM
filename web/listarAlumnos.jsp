<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : listadoDocentes
    Created on : 18-oct-2017, 13:40:31
    Author     : HaroMC
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Listado de alumnos </title>
    </head>
    <body>
        
        <table>
            <c:forEach items="${listadoAlumnos}" var="a">
            <tr>
                <td> <c:out value="${p.nombreCompleto}" /> </td>
                <td> <c:out value="${p.rut}" /> </td>
            </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
