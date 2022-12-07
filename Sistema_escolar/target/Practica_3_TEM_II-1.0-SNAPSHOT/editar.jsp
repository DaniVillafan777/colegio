<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Usuario"%>


<%
    Usuario usua = (Usuario)request.getAttribute("usua");
    
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
            <c:if test="${usua.id_u == 0}">Registro</c:if>
            <c:if test="${usua.id_u != 0}">Editar Usuario</c:if>
            </h1>
            <form action="MainController" method="post">
                <input type="hidden" name="id_u" value="${usua.id_u}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombres" value="${usua.nombres}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${usua.apellidos}"></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="${usua.correo}"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="text" name="pass" value="${usua.pass}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
