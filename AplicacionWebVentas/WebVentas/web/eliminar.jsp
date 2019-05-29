<%-- 
    Document   : eliminar
    Created on : 28-may-2019, 17:39:21
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar cliente</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h2>Eliminar cliente:</h2>
        <form name="form1" id="form1">
            <label for="email">Email:</label> 
            <input id="email" name="email" type="email" 
                   required="required" size="50" maxlength="250"/>
            <br/>
            <input type="reset" value="Limpiar"/>
            <input id="btn_eliminar" type="button" value="Eliminar"/> <!-- Con AJAX hay que poner button, no submit-->            
        </form>
        <div id="div_info" style="display: none">
            <p>Cliente : <span id="span_id">...</span></p>
        </div>
        <script src="js/md5.min.js"></script>
        <script src="js/encriptacion.js"></script>
        <script src="js/eliminar.js"></script>
    </body>
</html>
