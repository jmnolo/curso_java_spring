<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h2>Registro</h2>
        <form name="form1" id="form1" action="clientes.do" method="post"> <!--clientes.do, que es la url creada al crear el servlet.-->
            <label for="nombre">Nombre:</label>
            <input id="nombre" name="nombre" type="text" required="required" size="50" maxlength="50"/>
            <br/><label for="email">Email:</label>
            <input id="email" name="email" type="email" required="required" size="50" maxlength="250"/>
            <br/><label for="edad">Edad:</label>
            <input id="edad" name="edad" type="number" required="required" size="3" min="1" max="200"/>
            <br/><label for="activo">Activo:</label>
            <input id="activo" name="activo" type="checkbox" required="required" checked="checked"/>
            <br/><label for="password">Password:</label>
            <input id="password" name="password" type="password" required="required" size="50" maxlength="50"/>
            <input type="hidden" name="password_encrip" id="password_encrip"/>
            <br/>
            <input type="submit" value="Enviar"/>
            <input type="reset" value="Limpiar"/>
        </form>
        <script src="js/md5.min.js"></script> <%--Ya lo podemos utilizar en encriptacion.js--%>
        <script src="js/encriptacion.js"></script>
    </body>
</html>