<%@page import="com.emergentes.modelo.Personal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Usuario"%>


<%
    Personal perso = (Personal) request.getAttribute("perso");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema escolar</title>
    </head>
    <body>
        <h1>
            <c:if test="${perso.id_p == 0}">Registro</c:if>
            <c:if test="${perso.id_p != 0}">Editar Personal</c:if>
            </h1>
            <form action="MainControllerPersonal" method="post">
                <input type="hidden" name="id_p" value="${perso.id_p}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombre" value="${perso.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellido" value="${perso.apellido}"></td>
                </tr>
                <tr>
                    <td>Cargo</td>
                    <td><input type="text" name="cargo" value="${perso.cargo}"></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input type="text" name="direccion" value="${perso.direccion}"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${perso.telefono}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>