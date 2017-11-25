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
                    <label class="col-sm-2 control-label">Nombre completo jefe de familia</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nombreJefeFamilia" 
                               placeholder="Ingrese el nombre del usuario" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Rut</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="rut" 
                               placeholder="17676817-8" required="true">
                    </div>
                </div>          
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha de Nacimiento</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaNacimiento" 
                               required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Domicilio</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="domicilio" 
                               placeholder="Ingrese la direccion de domicilio" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Ciudad</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="ciudad" 
                               placeholder="Ingrese la ciudad de su domicilio" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Pais</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="pais" 
                               placeholder="Ingrese su pais de domicilio" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Correo</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" name="correo" 
                               placeholder="harold_developer@gmail.com" required="true">
                    </div> 
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefono</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="telefono" 
                               placeholder="2289302654" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Cantidad Integrantes</label>
                    <div class="col-sm-5">
                        <input type="int" class="form-control" name="integrantes" 
                               placeholder="    " required="true">
                    </div>
                </div> 
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombre Usuario</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nombreUsuario" 
                               placeholder="Ingresa un nombre de Usuario" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Contraseña</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="clave1" 
                               placeholder="" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Virificar Contraseña</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="clave2" 
                               placeholder="" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha de registro</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaRegistro" 
                               placeholder="" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">${mensaje}</label>
                    <div class="col-sm-5 control-label">
                        <button type="submit" class="btn btn-default" onClick="comprobarClave()">Agregar</button>
                    </div>
                </div>
                <input type="text" name="accion" value="agregarUsuario" hidden="true" />
            </form>
            <!--
private long codigo;
private String nombre;
private String contrasena;
private Date fechaRegistro;
private String rut;
private String perfil;
            -->
        </div>
        <script>
            function comprobarClave() {
                clave1 = document.f1.clave1.value;
                clave2 = document.f1.clave2.value;

                if (clave1 === clave2)
                    alert("Las dos claves son iguales...\nRealizaríamos las acciones del caso positivo");
                else
                    alert("Las dos claves son distintas...\nRealizaríamos las acciones del caso negativo");
            }
        </script>
    </body>
</html>
