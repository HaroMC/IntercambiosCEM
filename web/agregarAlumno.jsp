<%-- 
    Document   : agregarAlumno
    Created on : 29-10-2017, 09:48:19 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title>Agregar Alumno</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <%-- formulario de ingreso de un alumno--%>
        <div class="container-fluid">
            <h1 align="center">Agregar Alumno</h1>
            <form action="Servlet" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Numero Matricula</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="numeroMatricula" 
                               placeholder="Ingrese numero de matricula" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha Matricula</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaMatricula" required=""> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Rut Alumno</label>
                    <div class="col-sm-5">
                        <input type="number" class="form-control" name="rutPersona" 
                               placeholder="Ingrese el Rut del Alumno" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombres</label>
                    <div class="col-sm-5">
                        <input type="number" class="form-control" name="nombres" 
                               placeholder="Ingrese Nombres" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Apellido Paterno</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="apellidoPaterno" 
                               placeholder="Ingrese Apellido Päterno" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Apellido Materno</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="apellidoPaterno" 
                               placeholder="Ingrese Apellido Mäterno" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha Nacimiento</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaNacimiento" required=""> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Domicilio</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="domicilio" required=""
                               placeholder="Ingrese el domicilio"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Domicilio</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="domicilio" required=""
                               placeholder="Ingrese el domicilio"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Ciudad</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="ciudad" required=""
                               placeholder="Ingrese la ciudad"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Pais</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="pais" required=""
                               placeholder="Ingrese el pais"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Correo</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="correo" required=""
                               placeholder="Ingrese el Correo"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefono</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="telefono" required=""
                               placeholder="Ingrese el telefono"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">${mensaje}</label>
                    <div class="col-sm-7 control-label">
                        <button type="submit" class="btn btn-default">Agregar</button>
                    </div>
                </div>
                <input type="text" name="accion" value="agregarAlumno" hidden="true" />
            </form>
        </div>
    </body>
</html>
