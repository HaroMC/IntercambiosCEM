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

    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="container">
            <table id="modeloUsuarios">
                <caption>Listado de usuarios modelo</caption>
                <thead>
                    <tr>
                        <th scope="col" id="col_seleccion" class="oculto"><input type="checkbox" id="check0"> </th>
                        <th scope="col" id="cab_centro">Centro</th>
                        <th scope="col" id="cab_especialidad">Especialidad</th>
                        <th scope="col" id="cab_categoria">Categor&iacute;a</th>
                        <th scope="col" id="cab_tipo" >Tipo personal</th>
                        <th scope="col" id="cab_ambito">&Aacute;mbito</th>
                        <th scope="col" id="cab_unidad">Unidad</th>
                        <th scope="col" id="cab_modelo">Modelo</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <td colspan="8">Resultados usuarios modelo</td>
                    </tr>
                </tfoot>
                <tbody id="datos">
                    <tr id="fila1" class="original" onclick="seleccionarFila(id);">
                        <td headers="col_seleccion"><input type="checkbox" id="check1> </td>
                                                           <td headers="cab_centro">A</td>
                        <td headers="cab_especialidad">0123456789012345678901234567890123456789</td>
                        <td headers="cab_categoria">H</td>
                        <td headers="cab_tipo">0123456789</td>
                        <td headers="cab_ambito">Ambito 1</td>
                        <td headers="cab_unidad">01234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_modelo">01234567890123456789</td>
                    </tr>
                    <tr id="fila2" class="original"  onclick="seleccionarFila(id);">
                        <td class="oculto" headers="col_seleccion"><input type="checkbox" id="check2"> </td>
                        <td headers="cab_centro">C</td>
                        <td headers="cab_especialidad">0123456789012345678901234567890123456789</td>
                        <td headers="cab_categoria">012345678901234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_tipo">0123456789</td>
                        <td headers="cab_ambito">Ambito 1</td>
                        <td headers="cab_unidad">01234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_modelo">01234567890123456789</td>
                    </tr>
                    <tr id="fila3" class="original" onclick ="seleccionarFila(id);">
                        <td class="oculto" headers="col_seleccion"><input type="checkbox" id="check3"> </td>
                        <td headers="cab_centro">G</td>
                        <td headers="cab_especialidad">0123456789012345678901234567890123456789</td>
                        <td headers="cab_categoria">012345678901234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_tipo">0123456789</td>
                        <td headers="cab_ambito">Ambito 2</td>
                        <td headers="cab_unidad">01234567890123456789012345678901234567890123456789</td>
                        <td>01234567890123456789</td>
                    </tr>
                    <tr id="fila4" class="original" onclick ="seleccionarFila(id);">
                        <td class="oculto" headers="col_seleccion"><input type="checkbox" id="check4"> </td>
                        <td headers="cab_centro">0123456789012345678901234</td>
                        <td headers="cab_especialidad">0123456789012345678901234567890123456789</td>
                        <td headers="cab_categoria">012345678901234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_tipo">0123456789</td>
                        <td headers="cab_ambito">Ambito 3</td>
                        <td headers="cab_unidad">01234567890123456789012345678901234567890123456789</td>
                        <td headers="cab_modelo">01234567890123456789</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <script>
        function seleccionarFila(fila) {
           if (document.getElementById(fila).className === "seleccionada"){
                document.getElementById(fila).className = "original";
 
            }  else {
               document.getElementById(fila).className = "seleccionada";
 
           }
 
 
}
</script>

    </body>
</html>
