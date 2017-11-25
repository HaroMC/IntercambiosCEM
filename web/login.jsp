<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Bienvenido </title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Sistema de intercambios estudiantiles <br>
            Centro de Estudios Montreal</h1>

        <div class="container">
            <div class="row vertical-offset-100">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"> Ingrese al sistema :)</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="sesion.htm" method="post">
                            <div class="form-group">
                                <label for="nombreUsuario" class="col-lg-2 control-label">Nombre de Usuario:</label>
                                <div class="col-xs-3">
                                    <input type="text" class="form-control" name="nombreUsuario"
                                           required="true" id="nombreUsuario"
                                           placeholder="nombre Usuario">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="ejemplo_password_3" class="col-lg-2 control-label" style="size: 50">Contraseña</label>
                                <div class="col-xs-3">
                                    <input type="password" class="form-control" name="contrasena"
                                           required="true" id="ejemplo_password_3" 
                                           placeholder="Contraseña">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" class="btn btn-default">Entrar</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <a href="" class="btn btn-primary"> Si no esta registrado en el sistema presione aqui!! </a>
                                </div>
                            </div>                      
                            <label> ${mensaje} </label>         

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
