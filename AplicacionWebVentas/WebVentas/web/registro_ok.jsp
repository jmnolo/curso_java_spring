<%@page import="com.sinensia.modelo.logica.*"%>
<%@page import="com.sinensia.modelo.*"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Registro OK</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%= (new ServicioClientes()).obtenerUno("prueba@email.com").getNombre()%>
        <%    for (int i = 0; i < 10; i++ )
        {
        %>
            <h1>Registro OK</h1>
        <%
        } %>
        
    </body>
</html>
