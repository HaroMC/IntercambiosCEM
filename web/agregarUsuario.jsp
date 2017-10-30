<%-- 
    Document   : agregarUsuario
    Created on : 30-10-2017, 08:51:05 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Agregar Usuario</title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Agregar Usuario</h1>
            <form action="Servlet" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombre Usuario</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nombreUsuario" 
                               placeholder="Ingrese el nombre del usuario" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Contraseña</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="contrasenna" 
                               placeholder="Ingrese la contraseña" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha Registro</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaRegistro" 
                               required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Contraseña</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="contrasenna" 
                               placeholder="Ingrese la contraseña" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Tipo Usuario</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="perfil" 
                               required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">${mensaje}</label>
                    <div class="col-sm-5 control-label">
                        <button type="submit" class="btn btn-default">Agregar</button>
                    </div>
                </div>
                <input type="text" name="accion" value="agregarUsuario" hidden="true" />
            </form>
        </div>
    </body>
</html>
