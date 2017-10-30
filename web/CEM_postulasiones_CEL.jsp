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
        <h1>Postulasiones CEL's</h1>
           <div class="container">
            <h2>CEL's</h2>      
            <p>Buscar un CEL's puedes hacerlo aqui:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    
                
                <tr>
                    <th>Nombre del alumno</th>
                    <th>ID</th>
                    <th>Programa que cursa</th>
                    <th>Carrera que cursa</th>
                    <th>Numero de matricula</th>
                  
                </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td>John</td>
                        <td>0083</td>
                        <td>Desarrollo en MEAN</td>
                        <td>Ingenieria en informatica</td>
                        <td>7548569</td>
                       
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>0088</td>
                        <td>Desarrollo Full Stack</td>
                        <td>Ingenieria en Informatica</td>
                        <td>78545412</td>
                        
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>0090</td>
                        <td>Gestion de Personas</td>
                        <td>Recursos Humanos</td>
                        <td>785545489</td>
                       
                    <tr>
                        <td>Anja</td>
                        <td>0091</td>
                        <td>Pasteleria internacional</td>
                        <td>COcina</td>              
                        <td>456232871</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
