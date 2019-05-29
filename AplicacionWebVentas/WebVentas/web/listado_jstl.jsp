<%-- 
    Document   : listado_jstl
    Created on : 24-may-2019, 13:36:35
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinensia.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--Recogemos el Bean--%>
<% List<Cliente> listaCliPorNombre = (ArrayList) request.getAttribute("listaPorNombre");%> <%--listaPorNombre es un Bean, porque ArrayList es Serializable.--%>
<%-- Usamos el Bean--%>
<jsp:useBean id="listaPorNombre" type="java.util.ArrayList<Cliente>"
             scope="session"> <%--Ámbito de petición--%>
<jsp:getProperty property="*" name="listaPorNombre"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista JSTL - JavaBean</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h2>Tabla JSTL - JavaBean</h2>
        <%--<form method="GET" action="clientes.do"> <%-- Llamada al método doGET--%>
        <%--<input type="text" id="nombre" name="nombre"/>
            <input type="submit" value="BUSCAR"/>
        </form>--%> <%--Nos hemos llevado la busqueda a la cabecera de la página para que salga en todas las páginas.--%>
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Activo</th>
                </tr>
            </thead>
            
            <%--    for (Cliente cliente: listaCliPorNombre) {
            // Sustituimos el for-each de Java por el de JSTL.
            --%>
            <c:forEach items="${listaPorNombre}" var="cli">
                <%--<tr><td><%= cliente.getNombre()%></td><td><%= cliente.getEmail()%></td><td><%= cliente.getEdad()%></td><td><%= cliente.getActivo()%></td></tr>--%>
                <tr><td>${cli.nombre}</td>
                    <td>${cli.email}</td>
                    <td>${cli.edad}</td>
                    <td>${cli.activo}</td>
                </tr>
            <%-- // También se puede hacer con un <%for(){out.println("<tr><tr>...");}%+>
            }--%>
            </c:forEach>
           
        </table>
    </body>
</html>
