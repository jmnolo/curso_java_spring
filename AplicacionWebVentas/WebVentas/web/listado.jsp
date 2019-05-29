<%-- 
    Document   : listado
    Created on : 24-may-2019, 9:30:03
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%--Al igual que se hace en una clase servlet.java--%>
<%@page import="com.sinensia.modelo.logica.*" %>
<%@page import="com.sinensia.modelo.Cliente" %>
<%! ServicioClientes srvCli;%>
<% srvCli = new ServicioClientes();%>
<%List<Cliente> clientes = srvCli.obtenerTodos();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado clientes</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h2>Listado clientes</h2>
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Activo</th>
                </tr>
            </thead>
            
            <%    for (Cliente cliente: clientes) {
            %>
            <tr><td><%= cliente.getNombre()%></td><td><%= cliente.getEmail()%></td><td><%= cliente.getEdad()%></td><td><%= cliente.getActivo()%></td></tr>
            <% // También se puede hacer con un <%for(){out.println("<tr><tr>...");}%+>
            }%>
           
        </table>
    </body>
</html>
