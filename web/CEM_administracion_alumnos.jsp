<%-- 
    Document   : CEM_administracion_alumnos
    Created on : 25-10-2017, 19:37:39
    Author     : Bugueño
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
        <%@include  file="menuCEM.jsp" %>
        <div class="container">
            <h2>Alumnos</h2>      
            <p>Buscar un alumno puedes hacerlo aqui:</p>
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
                        <th>Eliminar</th>
                        <th>Editar</th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td>John</td>
                        <td>0083</td>
                        <td>Desarrollo en MEAN</td>
                        <td>Ingenieria en informatica</td>
                        <td>7548569</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>0088</td>
                        <td>Desarrollo Full Stack</td>
                        <td>Ingenieria en Informatica</td>
                        <td>78545412</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>0090</td>
                        <td>Gestion de Personas</td>
                        <td>Recursos Humanos</td>
                        <td>785545489</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    <tr>
                        <td>Anja</td>
                        <td>0091</td>
                        <td>Pasteleria internacional</td>
                        <td>COcina</td>              
                        <td>456232871</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    </tr>
                </tbody>
            </table>
            <a href="CEM_agregarAlumno.jsp" class="btn btn-primary">agregar alumno</a>
        </div>
        <div class="container">
            <h2>Notas por Asignatura</h2>           
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre  Alumno</th>
                        <th>Programa</th>
                        <th>Asignatura</th>
                        <th>Nota 1</th>
                        <th>Nota 2</th>
                        <th>Nota 3</th>
                        <th>Nota Final</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-primary">
                <i class="glyphicon glyphicon-pencil"></i>
            </button>
            <button type="button" class="btn btn-primary">
                <i class="glyphicon glyphicon-minus"></i>
            </button>

        </div>
        <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        -->
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
