<%-- 
    Document   : CEM_agregarFamilia
    Created on : 30-10-2017, 5:18:28
    Author     : Bugueño
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario de familia</h1>
        <h5>Los datos ingresados corresponden al jefe de familia</h5>
        <br/>
        <form action="Servlet" method="post" class="form-horizontal">

            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de nacimiento</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="numeroMatricula" 
                           placeholder="fecha de nacimiento" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Rut </label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="rutPersona" 
                           placeholder="Ingrese el Rut jefe de familia" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Nombre completo</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="nombres" 
                           placeholder="Ingrese Nombre completo" required="">
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
                <label class="col-sm-2 control-label">Cantidad de integrantes</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="ingrese cantidad de integrantes " required=""
                           placeholder="Ingrese el telefono"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">${mensaje}</label>
                <div class="col-sm-5 control-label">
                    <button type="submit" class="btn btn-default">Agregar</button>
                </div>
            </div>
            <input type="text" name="accion" value="agregarAlumno" hidden="true" />
        </form>
    </body>
</html>
