<%-- 
    Document   : listado_sql
    Created on : 24-may-2019, 12:28:24
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, java.sql.*" %>
<%@page import="javax.servlet.http.*, javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTADO JSTL</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h2>Listado con JSTL (Core y sql)</h2>
        
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Activo</th>
                    <th>Password</th>
                </tr>
            </thead>
            <%-- Formato con JSTL no tan cutre --%>
            <sql:setDataSource var="fuente" driver="com.mysql.cj.jdbc.Driver" 
                               url="jdbc:mysql://localhost:3306/bd_ventas?user=admin&password=Admin1234&useSSL=false&serverTimezone=UTC" 
                               user="admin" password="Admin1234"/>
            <sql:query dataSource="${fuente}" var="resultado">
                SELECT id, nombre, email, edad, activo, password FROM cliente;
            </sql:query>
            <c:forEach var="fila" items="${resultado.rows}">
                <tr>
                    <%--Cada uno de los campos de la base de datos--%>
                    <td><c:out value="${fila.nombre}"/></td>
                    <td><c:out value="${fila.email}"/></td>
                    <td><c:out value="${fila.edad}"/></td>
                    <td><c:out value="${fila.activo}"/></td>
                    <td><c:out value="${fila.password}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
