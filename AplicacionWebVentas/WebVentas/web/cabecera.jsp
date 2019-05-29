<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header><h1>Web ventas</h1></header>
<nav>
    <%--Con JSTL--%>
    <c:if test="${login != 'ok'}">
        <a href="login.jsp">Login</a>
        <a href="registro.jsp">Nuevo cliente</a> <!--jsp funciona igual que HTML, pero se pueden incluir código java.-->
        <br/><a href="editar.jsp">Editar AJAX + REST</a>
    </c:if>
    <c:if test="${login == 'ok'}">
        <br/><a href="listado.jsp">Listado clientes</a>
        <br/><a href="listado_sql.jsp">Listado JSTL - SQL clientes</a>
        <br/><a href="clientes.do">Listado JSTL - JavaBeans clientes</a> <%--Accedemos directamente al controlador con href="clientes.do"--%>
        <br/><a href="editar.jsp">Editar AJAX + REST</a>
        <br/><a href="eliminar.jsp">Eliminar cliente</a>

        <form method="GET" action="clientes.do"> <%-- Llamada al método doGET--%>
            <input type="text" id="nombre_busq" name="nombre_busq"/>
            <input type="submit" value="BUSCAR"/>
        </form>
    </c:if>
</nav>

<%-- En estas 2 se muestra la anterior búsqueda, porque la petición la manda al servidor y tarda en responder.
    En el mismo proceso doGet no puede realizar a la vez la búsqueda y asignarla en el momento a la cookie.--%>
<%--Cookies con JSP
<span><%= request.getCookies().length <= 1 ? ""
        : request.getCookies()[1].getValue() %></span>--%>
<%-- Cookies con EL (Expression Language) / JSTL--%>
<span>${cookie.nombre_busqueda.value}</span>  <%--Con expresiones regulares. JSTL.--%>

<%--Cookies con JavaScript. (La actual).--%>
<span id="span_cookie_nom"</span>

<%--Llamada a JavaScript, con el que podemos obtener la cookie en el momento.--%>
<script src="js/cookies.js"></script>